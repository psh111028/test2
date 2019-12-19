

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ProgTest2 {
	Map<String, MemberData> mapList = new Hashtable<String, MemberData>();
	void mapListAdd(String memberID, String name, String tel, String gender) {
		//mapList에 주어진 키와 값을 추가하는 메소드
		mapList.put(memberID, new MemberData(memberID, name, tel, gender));
	}
	
	void mapListRemove(String memberID) {
		//mapList에서 주어진 키와 일치하는 값을 삭제하는 메소드
		mapList.remove(memberID);
	}
	
	ArrayList getMapList() {
		//mapList 객체에 저장된 데이터를 ArrayList 객체로 저장하여 변환
		ArrayList<MemberData> alist = new ArrayList<MemberData>();
		Set<String> keyset = mapList.keySet(); //키셋 메소드를 이용해 map을 key형태로 변환 <자료형> 동일하게
		Iterator<String> keyiterator = keyset.iterator(); //Iterator로 key 생성
		while (keyiterator.hasNext()) {
			String k = keyiterator.next();
			MemberData v = mapList.get(k);
			alist.add(new MemberData(v.getMemberID(), v.getName(), v.getTel(), v.getGender()));
		}
		return alist;
	}
}