package com.github.ojil.j2se;

/**
 * This is the class used to create Strings from Error objects when running
 * under J2SE. The point is that the J2SE localization support is used so
 * the same approach won't work with J2ME, etc.<br>
 * Ex. usage:<br>
 * <blockquote>
 * <pre>
 * 	try {
 *          ...
 *	} catch (Exception ex) {
 *		Throwable t = ex.getCause();
 *		if (t instanceof com.github.ojil.core.Error) {
 *			com.github.ojil.j2se.Error e = 
 *                              new com.github.ojil.j2se.Error((com.github.ojil.core.Error) t);
 *			System.out.print(e.toString());
 *		}
 *	}
 * </pre>
 * </blockquote>
 * @author webb
 *
 */
@SuppressWarnings("serial")
public class Error extends com.github.ojil.core.Error {
    private static final String szMessage[][] = new String[com.github.ojil.core.Error.PACKAGE.COUNT][];
    
    {
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.CORE] = new String[com.github.ojil.core.ErrorCodes.COUNT];
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.CORE][com.github.ojil.core.ErrorCodes.BOUNDS_OUTSIDE_IMAGE] =
            Messages.getString("BOUNDS_OUTSIDE_IMAGE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.CORE][com.github.ojil.core.ErrorCodes.ILLEGAL_PARAMETER_VALUE] =
            Messages.getString("ILLEGAL_PARAMETER_VALUE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.CORE][com.github.ojil.core.ErrorCodes.IMAGE_MASK_SIZE_MISMATCH] =
            Messages.getString("IMAGE_MASK_SIZE_MISMATCH");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.CORE][com.github.ojil.core.ErrorCodes.MATH_DIVISION_ZERO] =
            Messages.getString("MATH_DIVISION_ZERO");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.CORE][com.github.ojil.core.ErrorCodes.MATH_NEGATIVE_SQRT] =
            Messages.getString("MATH_NEGATIVE_SQRT");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.CORE][com.github.ojil.core.ErrorCodes.MATH_PRODUCT_TOO_LARGE] =
            Messages.getString("MATH_PRODUCT_TOO_LARGE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.CORE][com.github.ojil.core.ErrorCodes.MATH_SQUARE_TOO_LARGE] =
            Messages.getString("MATH_SQUARE_TOO_LARGE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.CORE][com.github.ojil.core.ErrorCodes.NO_RESULT_AVAILABLE] =
            Messages.getString("PIPELINE_NO_RESULT");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.CORE][com.github.ojil.core.ErrorCodes.PIPELINE_EMPTY_PUSH] =
            Messages.getString("PIPELINE_EMPTY_PUSH");

        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM] = new String[com.github.ojil.algorithm.ErrorCodes.COUNT];
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.CONN_COMP_LABEL_COMPARETO_NULL] =
            Messages.getString("CONN_COMP_LABEL_COMPARETO_NULL");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.CONN_COMP_LABEL_OUT_OF_BOUNDS] =
            Messages.getString("CONN_COMP_LABEL_OUT_OF_BOUNDS");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.INPUT_TERMINATED_EARLY] =
            Messages.getString("INPUT_TERMINATED_EARLY");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.FFT_SIZE_LARGER_THAN_MAX] =
            Messages.getString("FFT_SIZE_LARGER_THAN_MAX");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.FFT_SIZE_NOT_POWER_OF_2] =
            Messages.getString("FFT_SIZE_NOT_POWER_OF_2");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.HEAP_EMPTY] =
            Messages.getString("HEAP_EMPTY");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.HISTOGRAM_LENGTH_NOT_256] =
            Messages.getString("HISTOGRAM_LENGTH_NOT_256");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.ILLEGAL_COLOR_CHOICE] =
            Messages.getString("ILLEGAL_COLOR_CHOICE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.IMAGE_NOT_COMPLEX32IMAGE] =
            Messages.getString("IMAGE_NOT_COMPLEX32IMAGE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.IMAGE_NOT_GRAY16IMAGE] =
            Messages.getString("IMAGE_NOT_GRAY16IMAGE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.IMAGE_NOT_GRAY32IMAGE] =
            Messages.getString("IMAGE_NOT_GRAY32IMAGE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.IMAGE_NOT_GRAY8IMAGE] =
            Messages.getString("IMAGE_NOT_GRAY8IMAGE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.IMAGE_NOT_RGBIMAGE] =
            Messages.getString("IMAGE_NOT_RGBIMAGE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.IMAGE_NOT_SQUARE] =
            Messages.getString("IMAGE_NOT_SQUARE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.IMAGE_SIZES_DIFFER] =
            Messages.getString("IMAGE_SIZES_DIFFER");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.IMAGE_TOO_SMALL] =
            Messages.getString("IMAGE_TOO_SMALL");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.INPUT_IMAGE_SIZE_NEGATIVE] =
            Messages.getString("INPUT_IMAGE_SIZE_NEGATIVE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.INPUT_TERMINATED_EARLY] =
            Messages.getString("INPUT_TERMINATED_EARLY");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.IO_EXCEPTION] =
            Messages.getString("IO_EXCEPTION");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.LOOKUP_TABLE_LENGTH_NOT_256] =
            Messages.getString("LOOKUP_TABLE_LENGTH_NOT_256");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.OBJECT_NOT_EXPECTED_TYPE] =
            Messages.getString("OBJECT_NOT_EXPECTED_TYPE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.OUTPUT_IMAGE_SIZE_NEGATIVE] =
            Messages.getString("OUTPUT_IMAGE_SIZE_NEGATIVE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.PARAMETER_OUT_OF_RANGE] =
            Messages.getString("PARAMETER_OUT_OF_RANGE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.PARAMETER_RANGE_NULL_OR_NEGATIVE] =
            Messages.getString("PARAMETER_RANGE_NULL_OR_NEGATIVE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.PARSE_ERROR] =
            Messages.getString("PARSE_ERROR");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.REDUCE_INPUT_IMAGE_NOT_MULTIPLE_OF_OUTPUT_SIZE] =
            Messages.getString("REDUCE_INPUT_IMAGE_NOT_MULTIPLE_OF_OUTPUT_SIZE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.SHRINK_OUTPUT_LARGER_THAN_INPUT] =
            Messages.getString("SHRINK_OUTPUT_LARGER_THAN_INPUT");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.STATISTICS_VARIANCE_LESS_THAN_ZERO] =
            Messages.getString("STATISTICS_VARIANCE_LESS_THAN_ZERO");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.STRETCH_OUTPUT_SMALLER_THAN_INPUT] =
            Messages.getString("STRETCH_OUTPUT_SMALLER_THAN_INPUT");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.SUBIMAGE_NO_IMAGE_AVAILABLE] =
            Messages.getString("SUBIMAGE_NO_IMAGE_AVAILABLE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.THRESHOLD_NEGATIVE] =
            Messages.getString("THRESHOLD_NEGATIVE");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.WARP_END_LEFT_COL_GE_END_RIGHT_COL] =
            Messages.getString("WARP_END_LEFT_COL_GE_END_RIGHT_COL");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.WARP_START_LEFT_COL_GE_START_RIGHT_COL] =
            Messages.getString("WARP_START_LEFT_COL_GE_START_RIGHT_COL");
        Error.szMessage[com.github.ojil.core.Error.PACKAGE.ALGORITHM][com.github.ojil.algorithm.ErrorCodes.WARP_START_ROW_GE_END_ROW] =
            Messages.getString("WARP_START_ROW_GE_END_ROW");
    }
    
	public Error(com.github.ojil.core.Error e) {
		super(e);
	}

        /**
         * Return a String localized for the current language etc. from this
         * Error object.
         * @return String localized for the current language describing the error.
         */
    public String getLocalizedMessage() {
        String szResult = null;
        switch (this.getPackage()) {
            case Error.PACKAGE.CORE:
                if (this.getCode() < 0 || this.getCode() >= com.github.ojil.core.ErrorCodes.COUNT) {
                    szResult = Messages.getString("Illegal_error_code_core") + 
                            new Integer(this.getCode()).toString();
                 } else {
                    szResult = szMessage[this.getPackage()][this.getCode()];
                }
                break;
            case Error.PACKAGE.ALGORITHM:
                if (this.getCode() < 0 || this.getCode() >= com.github.ojil.algorithm.ErrorCodes.COUNT) {
                    szResult = Messages.getString("Illegal_error_code_algorithm") + 
                            new Integer(this.getCode()).toString();
                 } else {
                    szResult = szMessage[this.getPackage()][this.getCode()];
                }
                break;
            case com.github.ojil.core.Error.PACKAGE.J2ME:
                szResult = Messages.getString("Illegal_error_code_j2me") +  " " +
                        new Integer(this.getCode()).toString();
                break;
            default:
                szResult = Messages.getString("Illegal_error_code_package") + " " +
                        new Integer(this.getPackage()).toString() + " " +
                        new Integer(this.getCode()).toString();
                break;
           }
           return szResult + ":  " + parameters();
    }

}
