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
	
	//ͼƬת����base64�ַ���
    public String GetImageStr()
    {//��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
        String imgFile = "E://Chrysanthemum.jpg";//�������ͼƬ
        InputStream in = null;
        byte[] data = null;
        //��ȡͼƬ�ֽ�����
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
        //���ֽ�����Base64����
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//����Base64��������ֽ������ַ���
    }
    */
}
