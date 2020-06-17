package com.spring.bms;
import static org.junit.Assert.*;

import java.io.Reader;
import java.util.HashMap;

import net.nurigo.java_sdk.api.GroupMessage;
import net.nurigo.java_sdk.api.Image;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.api.SenderID;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Test;

public class CoolsmsUnitTest {
  String api_key = "NCSMS0FHKZY8LQHO";
  String api_secret = "6DTP1HHAJ3QGP6ZYSBVRCC4EF5EB1J1Z";

  Message message = new Message(api_key, api_secret);
  GroupMessage groupMessage = new GroupMessage(api_key, api_secret);
  Image image = new Image(api_key, api_secret);
  SenderID senderID;
  JSONObject result;
  JSONArray result_array;
  HashMap<String, String> params = new HashMap<String, String>();

  @Test
  public void MessageTest() {
    try {
      // send					
      params.put("to", "");
      params.put("from", "01026927981");
      params.put("type", "SMS");
      params.put("text", "Coolsms Testing Message!");
      params.put("mode", "test");
      result = message.send(params);
      assertNotNull(result.get("group_id"));

      // balance
      result = message.balance();
      assertNotNull(result.get("cash"));

      // sent
      params.clear();
      try {
        result = message.sent(params);
        assertNotNull(result.get("data"));
      } catch (Exception e) {
        result = (JSONObject) JSONValue.parse(e.getMessage());
        assertEquals(result.get("code"), "NoSuchMessage");
      }

      // status
      result = message.getStatus(params);
      assertNotNull(result.get("data"));

      // cancel
      params.put("mid", "MIDTEST");
      result = message.cancel(params);
      assertTrue(!result.isEmpty());
    } catch (Exception e) {
      fail(e.toString());
    }
  }

}
