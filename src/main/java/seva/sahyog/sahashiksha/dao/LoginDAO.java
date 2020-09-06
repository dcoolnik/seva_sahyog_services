package seva.sahyog.sahashiksha.dao;

import seva.sahyog.sahashiksha.dto.UserLogin;

public interface LoginDAO {

    public UserLogin getUserLoginByUsername(String username);
}
