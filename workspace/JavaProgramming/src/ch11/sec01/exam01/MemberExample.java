package ch11.sec01.exam01;

import java.util.*;

public class MemberExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Member m1 = new Member("winter", "gkaqkr");
		Member m2 = new Member("winter", "smwrudnf");
		//Member m3 = m1;
		
		System.out.println(m1 == m2);
		//System.out.println(m1 == m3); //true
		
		System.out.println(m1.equals(m2));
		//System.out.println(m1.equals(m3));
		
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		//System.out.println(m3.hashCode());
		
		//동등 비교를 해서 같으면 중복 저장하지 않는다.
		HashSet<Member> hashSet = new HashSet<>();
		hashSet.add(m1);
		hashSet.add(m2);
		System.out.print("저장된 수: " + hashSet.size());
		
		//중복된 값을가지지 못함	
		//순서가 없다

	}

}
