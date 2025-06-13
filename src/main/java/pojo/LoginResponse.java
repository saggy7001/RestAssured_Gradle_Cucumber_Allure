package pojo;

public class LoginResponse {
    private String Authorization;
    private String success;
    private String error;

    public String getAuthorization() { return Authorization; }
    public void setAuthorization(String token) { this.Authorization = token; }
    public String getSuccess() { return success; }
    public void setSuccess(String success) { this.success = success; }
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
}
