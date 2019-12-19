

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ProgTest2 {
	Map<String, MemberData> mapList = new Hashtable<String, MemberData>();
	void mapListAdd(String memberID, String name, String tel, String gender) {
		//mapList�� �־��� Ű�� ���� �߰��ϴ� �޼ҵ�
		mapList.put(memberID, new MemberData(memberID, name, tel, gender));
	}
	
	void mapListRemove(String memberID) {
		//mapList���� �־��� Ű�� ��ġ�ϴ� ���� �����ϴ� �޼ҵ�
		mapList.remove(memberID);
	}
	
	ArrayList getMapList() {
		//mapList ��ü�� ����� �����͸� ArrayList ��ü�� �����Ͽ� ��ȯ
		ArrayList<MemberData> alist = new ArrayList<MemberData>();
		Set<String> keyset = mapList.keySet(); //Ű�� �޼ҵ带 �̿��� map�� key���·� ��ȯ <�ڷ���> �����ϰ�
		Iterator<String> keyiterator = keyset.iterator(); //Iterator�� key ����
		while (keyiterator.hasNext()) {
			String k = keyiterator.next();
			MemberData v = mapList.get(k);
			alist.add(new MemberData(v.getMemberID(), v.getName(), v.getTel(), v.getGender()));
		}
		return alist;
	}
}