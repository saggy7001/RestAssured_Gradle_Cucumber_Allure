package clients;

import pojo.LoginRequest;
import pojo.LoginResponse;
import utils.ApiResponse;

public class LoginClient extends BaseApiClient{
    public ApiResponse<LoginResponse> login(LoginRequest request) {
        return post("/login", request, LoginResponse.class);
    }
}
