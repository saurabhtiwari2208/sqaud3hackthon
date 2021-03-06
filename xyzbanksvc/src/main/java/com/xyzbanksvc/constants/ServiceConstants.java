package com.xyzbanksvc.constants;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * ServiceConstants
 */
public class ServiceConstants {

	public static final String SUCCESS_STATUS_CODE = "00";
	public static final String FAILURE_STATUS_CODE = "01";

    //Authentication
    public static final String AUTH_SUCCESS_MESSAGE = "Authentication Successful";
    public static final String AUTH_FAILURE_MESSAGE = "Authentication Failed";
    public static final String ENCODING_ALGO = "SHA3-256";
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s:%s";
    
    public static final String FAV_PAYEE_UPDATED = "Favorite Payee Updated";
    public static final String FAV_PAYEE_UPDATE_FAILED = "Favorite Payee Update Failed";
	public static final String FAV_PAYEE_DELETED = "Favorite Payee Deleted";
	public static final String FAV_PAYEE_DELETE_FAILED = "Favorite Payee Delete Failed";

	public static final int ACCOUNT_NO_MIN_LENGTH = 5;
	public static final int ACCOUNT_NO_MAX_LENGTH = 8;

	public static final int SUBSTRING_COUNT = 9;
}