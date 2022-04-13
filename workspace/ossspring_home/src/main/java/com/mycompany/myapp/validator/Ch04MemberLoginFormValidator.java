package com.mycompany.myapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.myapp.controller.dto.Ch04Member;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Ch04MemberLoginFormValidator implements Validator{
	//유효성 검사가 가능한 객체인지 조사
		@Override
		public boolean supports(Class<?> clazz) {
			// ch04membe를 포함한 자식 객체인지 확인한다.
			log.info("실행");
			boolean result = Ch04Member.class.isAssignableFrom(clazz);
			
			//result가 true인 값만 validate 실행한다.
			return result;
		}

		@Override
		public void validate(Object target, Errors errors) {
			// TODO Auto-generated method stub
			log.info("실행");
			Ch04Member member  = (Ch04Member) target;
			
			//mid 검사
			if(member.getMid() == null || member.getMid().trim().equals("")) {
				errors.rejectValue("mid",null, "mid가 필수 입력 사항입니다"); //에러코드와 에러메시지이다.
			} else {
				if(member.getMid().length() < 4) { //조건이 4글자 미만이라는 오류 조건
					errors.rejectValue("mid","errors.mid.minlength", new Object[] {4}, "mid는 최소 4글자 이상이여야 한다");
				}
			}
			
			//mpassword 검사
				if(member.getMpassword() == null || member.getMpassword().trim().equals("")) {
					errors.rejectValue("mpassword",null, "mpassword가 필수 입력 사항입니다"); //에러코드와 에러메시지이다.
				} else {
					if(member.getMid().length() < 8) { //조건이 4글자 미만이라는 오류 조건
						errors.rejectValue("mpassword", null, "mid는 최소 8글자 이상이여야 한다");
					}
				}
		}

}
