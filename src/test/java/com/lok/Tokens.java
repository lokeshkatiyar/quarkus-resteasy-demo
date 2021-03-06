package com.lok;

import java.util.Optional;

public class Tokens {
    public static final String USER_TOKEN = Optional
            .ofNullable(System.getenv().get("USER_TOKEN"))
            .orElse("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjZklBRE5feHhDSm1Wa1d5Ti1QTlhFRXZNVVdzMnI2OEN4dG1oRUROelhVIn0.eyJleHAiOjE2MTIxMjY2MTQsImlhdCI6MTYxMjEyNjMxNCwianRpIjoiNDM0ZjkzZWYtMGMyYS00YmQ0LWExOTQtZjM5YTRlOGU0NTI1IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MTgwL2F1dGgvcmVhbG1zL3F1YXJrdXMiLCJzdWIiOiJlYjQxMjNhMy1iNzIyLTQ3OTgtOWFmNS04OTU3ZjgyMzY1N2EiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJiYWNrZW5kLXNlcnZpY2UiLCJzZXNzaW9uX3N0YXRlIjoiMjAzOWZhOGMtNGJkYi00ZDhmLThhZGQtZjA3ZGIwMTQ3ZDJiIiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJ1c2VyIl19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6ImFsaWNlIn0.ODNVjx7a8F3IVe5DzK7axCgPnBakAmp_eS9rptPeK8QveMLVudVv86BJpv5bwDHfcdlOmm9jz6i1sPKnOOkO_cna4p2-1_DQwHTM-Kk86XFrXuH21FLkHfxfbS0MTyDt4nnnKjz2GZOy3KFhfnVzDSyzrchcBze7htKoZWsr7eLYDcZxV8r8I0kxqh6UAcnNJDtX-0NpKrdptcEqPP0bGAODSRMAUtY_2LqchdRRUFQzkskwZyOUm-uIe1rukHFCvYGoKBqrXNgdmEfnwReHtKlXDa2wZuxEJBnMVzuvy_8_qcCVBzfkgeGpsOJRm-MFMMhQHCmZ35bYv2xk-rTrbQ");
    public static final String ADMIN_TOKEN = Optional
            .ofNullable(System.getenv().get("APC-ADMIN_TOKEN-Secret"))
            .orElse("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjZklBRE5feHhDSm1Wa1d5Ti1QTlhFRXZNVVdzMnI2OEN4dG1oRUROelhVIn0.eyJleHAiOjE2MTIxNTc1NzgsImlhdCI6MTYxMjE1NzI3OCwianRpIjoiZGQ0MGMzOTYtNzZkZi00MGIxLTk3NjktMjg5YmZjMmEzZWVkIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MTgwL2F1dGgvcmVhbG1zL3F1YXJrdXMiLCJzdWIiOiJhZjEzNGNhYi1mNDFjLTQ2NzUtYjE0MS0yMDVmOTc1ZGI2NzkiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJiYWNrZW5kLXNlcnZpY2UiLCJzZXNzaW9uX3N0YXRlIjoiMjlkOGI3ZGEtYzJjNi00YjlmLThhYjUtZTU5NDc4Njg4MDYwIiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJhZG1pbiIsInVzZXIiXX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwicHJlZmVycmVkX3VzZXJuYW1lIjoiYWRtaW4ifQ.XEpNYqw0NPS3Iw-OyhLag8rIruXabKyKK99iS7pu4-xhUQ8xbmR9DbMKnLy0NIDjQ6VXZINu6JZv7GHgvFyT8TUh8xUKO6cb4o5uZJw5A8F85T5sigaji62Gwgz189cJGx5VhmdsuhdavUvYnA4x3wHZ2N_nEM_BxV_mULJld7CXRPiLUXwvPCtckwcQ_nkILAQVWetgwMaMmEUKwlyDziF1y-TeRRf8MffF53GCd8e0znEFC_mLMLhefZhdrF_wQk_w6uAp4MRPVyBVpRu4fYk54qSsdrgXHUEws4r43P4VyDKHNFwZUFLbVDMBfPFW6GNrt2IlT_WsmGrtOWNNJA");
}
