package com.example.tiendaonline.proyectomvc.servicios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class ServicioImagen {
	
	Cloudinary cloudinary;

	private Map<String,String> valuesMap=new HashMap<>();
	
	public ServicioImagen() {
		valuesMap.put("cloud_name","dhe68zyh4");
		valuesMap.put("api_key","696394224419529");
		valuesMap.put("api_secret","7ykAU9KVPKscRR_f1WNqKUNcl6Y");
		cloudinary=new Cloudinary(valuesMap);
	}
	
	public Map SubirImagen(MultipartFile imagen) throws IOException
	{
		File file=Convertir(imagen);
		
		Map result=cloudinary.uploader().upload(file,ObjectUtils.emptyMap());
		file.delete();
		return result;
	}
	
	private File Convertir(MultipartFile imagen) throws IOException{
		File file=new File(imagen.getOriginalFilename());
		
		FileOutputStream fo=new FileOutputStream(file);
		fo.write(imagen.getBytes());
		fo.close();
		return file;
	}
	
}
