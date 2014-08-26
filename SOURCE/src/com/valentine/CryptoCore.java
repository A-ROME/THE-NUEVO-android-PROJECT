package com.valentine;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class CryptoCore {
	static final String TAG = "CryptoCore";
	
	protected SecretKeySpec sks;
	private Context context;
	
	
	
	CryptoCore(Context context ){
	this.context=context;
		
		}
	
	public String Decrypt(String password,String decode){
		String decoded = null;
		try {
			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
			sr.setSeed(password.getBytes());
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			kg.init(128, sr);
			sks = new SecretKeySpec((kg.generateKey()).getEncoded(),
			"AES");
		
		
	} catch (Exception e) {
		Log.e(TAG, "AES secret key spec error");
		Toast toast = Toast.makeText(context.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG );
		toast.show();
	}
		
		
		try {
		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.DECRYPT_MODE, sks);
		decoded=c.doFinal(toByte(decode)).toString();
		
	
		
		
		} catch (Exception e) {
		Log.e(TAG, "AES decryption error");
		Toast toast = Toast.makeText(context.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG );
		toast.show();
		}
		
		
		return decoded;
}
	
	public String  Encrypt(String password, String encode){
		SecretKeySpec sks = null;
		
		
		try {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(password.getBytes());
		KeyGenerator kg = KeyGenerator.getInstance("AES");
		kg.init(128, sr);
		sks = new SecretKeySpec((kg.generateKey()).getEncoded(),
		"AES");
		
		
		} catch (Exception e) {
		Log.e(TAG, "AES secret key spec error ");
		Toast toast = Toast.makeText(context.getApplicationContext(), e.getMessage()+" 1", Toast.LENGTH_LONG );
		toast.show();
		}
		// Encode the original data with AES
		byte[] encodedBytes = null;
		
		
		try {
		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.ENCRYPT_MODE, sks);
		encodedBytes = c.doFinal(encode.getBytes());
	
		
		
		} catch (Exception e) {
			Log.e(TAG, "AES encryption error");
			Toast toast = Toast.makeText(context.getApplicationContext(), e.getMessage()+" 2", Toast.LENGTH_LONG );
			toast.show();
		}
		
		return toHex(encodedBytes);
	}
	
	
	
	  private  byte[] toByte(String hexString) {
          int len = hexString.length()/2;
          byte[] result = new byte[len];
          for (int i = 0; i < len; i++)
                  result[i] = Integer.valueOf(hexString.substring(2*i, 2*i+2), 16).byteValue();
          return result;
  }

 private  String toHex(byte[] buf) {
          if (buf == null)
                  return "";
          StringBuffer result = new StringBuffer(2*buf.length);
          for (int i = 0; i < buf.length; i++) {
                  appendHex(result, buf[i]);
          }
          return result.toString();
  }
  private final  String HEX = "0123456789ABCDEF";
  private  void appendHex(StringBuffer sb, byte b) {
          sb.append(HEX.charAt((b>>4)&0x0f)).append(HEX.charAt(b&0x0f));
  }
  public  String toHex(String txt) {
      return toHex(txt.getBytes());
}
public  String fromHex(String hex) {
      return new String(toByte(hex));
}
}
