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
																				//JASOn���� Ʈ�� ������ �������� �Ѵ�!!
		List<HashMap<String, Object>> listMajorGroup = new ArrayList<>();		//���� ���ΰ� 2���� 2���� �ž� �Ѵ�

		for (HashMap<String, Object> branch : list) {
			HashMap<String, Object> major = addMajorGroup(listMajorGroup, branch); 	//major list ���� ������ ����� ������ �������θ� ã�Ƴ���
			//�бⱹ�簡 ��� �������θ� 
			HashMap<String, Object> minor = addMinorGroup(major, branch);				//minor list ����
			if( minor == null ) {
				continue;
			}
			addBranchOffice(minor, branch);
		}

		result.setData(LIST, listMajorGroup);	//�ϴ� �����⸸(list No.1 = listMajorGroup) ������ ���ʿ����� �̹� hierarchy �۾� �Ϸ�

		return result;
	}

	private HashMap<String, Object> addMajorGroup(List<HashMap<String, Object>> list, HashMap<String, Object> item) {	//null�Ǹ� ����

		Long branch_major_id = (Long) item.get(MAJOR_ID);
 
		for (HashMap<String, Object> major : list) {
			Long id = (Long) major.get(MAJOR_ID);
			if (branch_major_id.equals(id) == true) {
				return major;
			}//ó�� �ϴ� ����
		}

		HashMap<String, Object> new_branch_major_group = new HashMap<>();	//�бⱹ�� ������Ʈ ����(�ϳ��� ���� �̸�, ��ġ ���� ������ �ִ�)>>

		String branch_major_group_name = (String) item.get(MAJOR_NAME);

		new_branch_major_group.put(MAJOR_ID, branch_major_id);
		new_branch_major_group.put(MAJOR_NAME, branch_major_group_name);

		list.add(new_branch_major_group);	//����� �������ֱ� ���� �ϴ� list�� ����(response������)

		return new_branch_major_group;	//�� �������� ID/NAME�� ������ ������Ʈ 1�� ����
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
