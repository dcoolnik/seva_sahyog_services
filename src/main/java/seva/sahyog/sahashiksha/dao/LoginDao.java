package seva.sahyog.sahashiksha.dao;

import seva.sahyog.sahashiksha.dto.UserLogin;

public interface LoginDao {

    public UserLogin getUserLoginByUsername(String username);

    public long saveUserLogin(UserLogin userLogin);

}
