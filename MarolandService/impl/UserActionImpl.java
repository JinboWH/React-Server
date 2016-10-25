package greenlander.action.impl;

import greenlander.websocket.sessionmanager.WebSocketSessionManager;
import greenlander.websocket.transmission.WsPatientImage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sun.misc.BASE64Encoder;

public class UserActionImpl
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private WebSocketSessionManager sessionManager;
	
	public String getUserId()
	{
		String sql = "select * from t_user where rownum = 1";
		
	  	Object o = jdbcTemplate.queryForObject(sql, new RowMapper<String>()
		{
			public String mapRow(ResultSet rs, int rownum) throws SQLException
			{
				String id = rs.getString("UserId");
				return id;
			}
		});
	  	
	  	return o.toString();
	}
	
	/*
	public void SendImage()
	{
		WsPatientImage wsPatientImage = new WsPatientImage();
		wsPatientImage.imageData = GetImageStr();
		
		sessionManager.SendObject(wsPatientImage);
	}
	
	//图片转化成base64字符串
    public String GetImageStr()
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        String imgFile = "E://Chrysanthemum.jpg";//待处理的图片
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try 
        {
            in = new FileInputStream(imgFile);        
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }
    */
}
