/*
#================================================================================
# THIS DOCUMENT IS THE PROPERTY OF UTC AEROSPACE SYSTEMS AND CONTAINS
# CONFIDENTIAL AND/OR PROPRIETARY INFORMATION. YOU MAY NOT POSSESS, USE, COPY OR
# DISCLOSE THIS DOCUMENT OR ANY INFORMATION IN IT, FOR ANY PURPOSE, INCLUDING
# WITHOUT LIMITATION, TO DESIGN, MANUFACTURE OR REPAIR PARTS, OR OBTAIN ANY
# GOVERNMENT APPROVAL TO DO SO, WITHOUT UTC AEROSPACE SYSTEMS’S EXPRESS WRITTEN
# PERMISSION. NEITHER RECEIPT NOR POSSESSION OF THIS DOCUMENT ALONE, FROM ANY
# SOURCE, CONSTITUTES SUCH PERMISSION. POSSESSION, USE, COPYING OR DISCLOSURE BY
# ANYONE WITHO
# # U.S. Export Classification: 9E991UT UTC AEROSPACE SYSTEMS’S EXPRESS WRITTEN PERMISSION IS NOT
# AUTHORIZED AND MAY RESULT IN CRIMINAL AND/OR CIVIL LIABILITY

# xClass Item Identifier: CLS11312279
#================================================================================
 */
package com.lok;

import java.util.Optional;

/**
 *
 * @author LKATIYAR
 */
public class Constants {
	public static final String APC_Auth = Optional
			.ofNullable(System.getenv().get("APC_Auth"))
			.orElse("7c92e20dad");
	public static final String APC_AUTH_SECRET = Optional
			.ofNullable(System.getenv().get("APC-Auth-Secret"))
			.orElse("339484325aa8120");
	public static final String API_URL = Optional
			.ofNullable(System.getenv().get("URL"))
			.orElse("https://www.air-port-codes.com/api/v1");

	public static final String TOKEN_API_CREDENTIALS = Optional
			.ofNullable(System.getenv().get("TOKEN_API_CREDENTIALS"))
			.orElse("Basic YmFja2VuZC1zZXJ2aWNlOnNlY3JldA==");

	public static final String TOKEN_URL=Optional
			.ofNullable(System.getenv().get("TOKEN_URL"))
			.orElse("http://localhost:8180/auth/realms/quarkus/protocol/openid-connect/token");
}
