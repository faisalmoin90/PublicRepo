package com.alraedah.assignment.model;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @author FaisalMOI
 *
 */
public class ErrorsVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ErrorVO> errors;

	public ErrorsVO() {
	}

	public ErrorsVO(String functional, String code, String description) {
		this.errors= new ArrayList<>();
		this.errors.add(new ErrorVO(functional, code, description));
	}

	public List<ErrorVO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorVO> errors) {
		this.errors = errors;
	}

	public void addError(ErrorVO errorVO) {
		if(Objects.isNull(errorVO)) {
			return;
		}
		if(Objects.isNull(errors)) {
			this.errors = new ArrayList<>();
		}
		errors.add(errorVO);
	}

	/**
	 * Static method to add error on existing ErrosVO list or create new if passed null
	 *
	 * @param ErrorsVO instance can be null
	 * @param ErrorVO instance
	 *
	 * @return ErrorsVO return
	 *
	 * <pre>{@code
     * ErrorsVO.addError(null, error)
     * }</pre>if passed null create new ErrorsVO object and add the error in its list
	 */
	public static ErrorsVO addError(ErrorsVO errorsVO, ErrorVO errorVO, boolean addAtFirstPosition) {
		if (Objects.isNull(errorsVO)) {
			errorsVO = new ErrorsVO();
			errorsVO.setErrors(new ArrayList<>());
		}
		if (Objects.isNull(errorsVO.getErrors())) {
			errorsVO.setErrors(new ArrayList<>());
		}
		if (Objects.nonNull(errorVO)) {
			if (addAtFirstPosition) {
				errorsVO.getErrors().add(0, errorVO);
			} else {
				errorsVO.getErrors().add(errorVO);
			}
		}
		return errorsVO;
	}

}
