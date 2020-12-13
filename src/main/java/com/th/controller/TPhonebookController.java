package com.th.controller;

import com.th.entity.R;
import com.th.entity.TPhonebook;
import com.th.utils.QiniuUploadUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/tphonebook")
public class TPhonebookController extends BaseController<TPhonebook>{
	
	/**
	 * 页面jsp
	 */
	@RequestMapping("/page")
	public String page(){
		return "tphonebook";
	}

    /**
     * 页面html
     */
    @RequestMapping("/html")
    public String html(){
        return "redirect:/html/tphonebook.html";
    }

    //根据首字符查询电话
	@GetMapping(value="/loadAllTPhonebook")
	@ResponseBody
	public R loadAllTPhonebook() throws Exception {
		Map<String,Object> map=new HashMap<>();
		char [] letters={'A','B','C','D','E','F','G','H','I','J','K',
				'L','M','N','O','P','Q','R','S','T','U','V',
				'W','X','Y','Z','#'};
		String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0;i<letters.length;i++){
			String letter=String.valueOf(letters[i]);
			//构建查询的条件对象
			TPhonebook queryTPhonebook = new TPhonebook();
			List<TPhonebook> phoneBooks = null;
			if(word.indexOf(letter)!=-1){
				//设置姓名首字母
				queryTPhonebook.setInitial(letter);
				//根据用户姓名拼音首字母条件进行查询
				phoneBooks = baseService.findManyByPramas(queryTPhonebook);
				if(phoneBooks.size()>0){
					map.put(letter,phoneBooks);
				}
			}else{
				//设置姓名首字母
				queryTPhonebook.setInitial("#");
				//根据用户姓名拼音首字母条件进行查询
				phoneBooks = baseService.findManyByPramas(queryTPhonebook);
				if(phoneBooks.size()>0){
					map.put("#",phoneBooks);
				}
			}

		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("data",map);
		System.out.println(R.ok(resultMap));
		return R.ok(resultMap);

	}

	/**
	 *  完成通讯录图片上传
	 * @param file 传来的图片文件
	 * @return 上传的结果
	 */
	@RequestMapping("/uploadImage")
	@ResponseBody
	public Map<String,Object> uploadImage(MultipartFile file){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			map = QiniuUploadUtils.upload(file);
		} catch (IOException e) {
			e.printStackTrace();
			map.put("code",0);
			map.put("msg","服务器异常！！");
		}
		return map;
	}








}
