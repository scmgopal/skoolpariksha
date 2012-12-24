package com.prabhat.view.question.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.prabhat.hibernate.entity.Question;
import com.prabhat.service.question.QuestionService;
import com.prabhat.view.question.dto.UserQuestionDto;
import com.prabhat.view.test.dto.UserTestDto;

public class UserQuestion extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2184737663217858139L;
	private UserQuestionDto questionDto;
	private UserTestDto userTestDto;
	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String action = request.getParameter("actionName");
		if (action == null) {
			action = getQuestionDto().getActionName();
		}
		
		
		if (action != null && action.equals("addQuestionView")) {
			return addQuestionView();
		} if (action != null && action.equals("saveQuestion")) {
			return saveQuestion();
		} else {
			getQuestionDto().setTestId(userTestDto.getTestId());
			return getQuestionListView();
		}
	}
	
	private String getQuestionListView() {
		QuestionService questionService = new QuestionService();
		
		List<Question> questions = questionService.getQuestions(getQuestionDto().getTestId());
		getQuestionDto().setTestId(getQuestionDto().getTestId());
		getQuestionDto().setQuestionList(questions);
		return "userquestion";
	}
	
	private String addQuestionView() {
		return "addquestion";
	}
	
	private String saveQuestion() {
		QuestionService questionService = new QuestionService();
		questionService.saveQuestion(getQuestionDto());
		return getQuestionListView();
	}
	
	private String editQuestion() {
		return "addquestion";
	}
	
	public void validate() {
		if (getQuestionDto().getActionName() != null && getQuestionDto().getActionName().equals("saveQuestion")) {
			if (getQuestionDto().getQuestionName() == null ||  getQuestionDto().getQuestionName().trim().length() == 0 ){	
				addFieldError("questionDto.questionName", "Question name is required." );
			}
			
			if (getQuestionDto().getOptA() == null || getQuestionDto().getOptA().trim().length() == 0 ){	
				addFieldError("questionDto.optA", "Option A is required." );
			}
			if (getQuestionDto().getOptB() == null || getQuestionDto().getOptB().trim().length() == 0 ){	
				addFieldError("questionDto.optB", "Option B is required." );
			}
			if (getQuestionDto().getOptC() == null || getQuestionDto().getOptC().trim().length() == 0 ){	
				addFieldError("questionDto.optC", "Option C is required." );
			}
			if (getQuestionDto().getOptD() == null || getQuestionDto().getOptD().trim().length() == 0 ){	
				addFieldError("questionDto.optD", "Option D is required." );
			}
			
			if (getQuestionDto().getOptAns().equals("-1") ){	
				addFieldError("questionDto.optAns", "Answer Option is required." );
			}
			addQuestionView();
		}
	}
	
	
	/**
	 * @return the questionDto
	 */
	public UserQuestionDto getQuestionDto() {
		if (questionDto == null) {
			questionDto = new UserQuestionDto();
		}
		return questionDto;
	}

	/**
	 * @param questionDto the questionDto to set
	 */
	public void setQuestionDto(UserQuestionDto questionDto) {
		this.questionDto = questionDto;
	}

	/**
	 * @return the userTestDto
	 */
	public UserTestDto getUserTestDto() {
		return userTestDto;
	}

	/**
	 * @param userTestDto the userTestDto to set
	 */
	public void setUserTestDto(UserTestDto userTestDto) {
		this.userTestDto = userTestDto;
	}
}
