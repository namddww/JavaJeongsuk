package org.kt.bo.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.kt.bo.api.data.mapper.postgre.BranchOfficeMapper;
import org.kt.bo.api.response.Response;
import org.kt.bo.api.service.batch.BatchJob;
import static org.kt.bo.api.util.Constants.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchOfficeService {

	private static Logger logger = LoggerFactory.getLogger(BatchJob.class);

	@Autowired
	private BranchOfficeMapper branchOfficeMapper;

	public Response searchBranchOffice(HashMap<String, Object> body) {

		Response result = Response.from();
		HashMap<String, Object> param = new HashMap<>();

		if (body.containsKey(BRANCH_NAME) == true) {
			param.put(BRANCH_NAME, body.get(BRANCH_NAME));
		}

		List<HashMap<String, Object>> list = branchOfficeMapper.selectBranchOfficeSimpleInfo(param);

		result.setData(LIST, list);

		return result;
	}

	public Response getBranchOfficeListByBranchId(HashMap<String, Object> body) {

		Response result = Response.from();
		HashMap<String, Object> param = new HashMap<>();

		if (body.containsKey(BRANCH_ID) == true) {
			param.put(BRANCH_ID, body.get(BRANCH_ID));
		}

		List<HashMap<String, Object>> list = branchOfficeMapper.selectBranchOfficeList(param);
																				//JASOn으로 트리 구조를 만들어줘야 한다!!
		List<HashMap<String, Object>> listMajorGroup = new ArrayList<>();		//광역 본부가 2개면 2개가 돼야 한다

		for (HashMap<String, Object> branch : list) {
			HashMap<String, Object> major = addMajorGroup(listMajorGroup, branch); 	//major list 만듦 없으면 만들고 있으면 광역본부를 찾아내줌
			//분기국사가 어느 광역본부를 
			HashMap<String, Object> minor = addMinorGroup(major, branch);				//minor list 만듦
			if( minor == null ) {
				continue;
			}
			addBranchOffice(minor, branch);
		}

		result.setData(LIST, listMajorGroup);	//일단 껍데기만(list No.1 = listMajorGroup) 보내고 안쪽에서는 이미 hierarchy 작업 완료

		return result;
	}

	private HashMap<String, Object> addMajorGroup(List<HashMap<String, Object>> list, HashMap<String, Object> item) {	//null되면 죽음

		Long branch_major_id = (Long) item.get(MAJOR_ID);
 
		for (HashMap<String, Object> major : list) {
			Long id = (Long) major.get(MAJOR_ID);
			if (branch_major_id.equals(id) == true) {
				return major;
			}//처음 일단 무시
		}

		HashMap<String, Object> new_branch_major_group = new HashMap<>();	//분기국사 오브젝트 생성(하나에 대한 이름, 위치 등을 가지고 있는)>>

		String branch_major_group_name = (String) item.get(MAJOR_NAME);

		new_branch_major_group.put(MAJOR_ID, branch_major_id);
		new_branch_major_group.put(MAJOR_NAME, branch_major_group_name);

		list.add(new_branch_major_group);	//결과로 내보기주기 위해 일단 list로 넣음(response데이터)

		return new_branch_major_group;	//빈 공간에서 ID/NAME을 넣으면 오브젝트 1개 생성
	}

	@SuppressWarnings("unchecked")
	private HashMap<String, Object> addMinorGroup(HashMap<String, Object> branch_major_group,
			HashMap<String, Object> item) {

		List<HashMap<String, Object>> listMinor = (List<HashMap<String, Object>>) branch_major_group.get(MINOR_LIST);
		if (listMinor == null) {
			listMinor = new ArrayList<>();
			branch_major_group.put(MINOR_LIST, listMinor);
		}

		Long branch_minor_id = (Long) item.get(MINOR_ID);
		if( branch_minor_id == null ) {
			return null;
		}

		for (HashMap<String, Object> record : listMinor) {
			Long id = (Long) record.get(MINOR_ID);
			if (branch_minor_id.equals(id) == true) {
				return record;
			}
		}

		HashMap<String, Object> new_branch_minor_group = new HashMap<>();

		String branch_minor_group_name = (String) item.get(MINOR_NAME);

		new_branch_minor_group.put(MINOR_ID, branch_minor_id);
		new_branch_minor_group.put(MINOR_NAME, branch_minor_group_name);

		listMinor.add(new_branch_minor_group);

		return new_branch_minor_group;
	}

	private HashMap<String, Object> addBranchOffice(HashMap<String, Object> branch_major_group,
			HashMap<String, Object> item) {

		List<HashMap<String, Object>> listOffice = (List<HashMap<String, Object>>) branch_major_group.get(OFFICE_LIST);
		if (listOffice == null) {
			listOffice = new ArrayList<>();
			branch_major_group.put(OFFICE_LIST, listOffice);
		}

		Long branch_id = (Long) item.get(BRANCH_ID);
		if( branch_id == null ) {
			return null;
		}

		for (HashMap<String, Object> record : listOffice) {
			Long id = (Long) record.get(BRANCH_ID);
			if (branch_id.equals(id) == true) {
				return record;
			}
		}

		HashMap<String, Object> new_branch = new HashMap<>();

		String branch_name = (String) item.get(BRANCH_NAME);

		new_branch.put(MINOR_ID, branch_id);
		new_branch.put(MINOR_NAME, branch_name);

		listOffice.add(new_branch);

		return new_branch;
	}
}
