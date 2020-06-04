package com.bms.service.mypage;

import java.sql.SQLException;
import java.util.Map;

public interface MypageService {

	Map<String, Object> getMember(String id)throws SQLException;
}
