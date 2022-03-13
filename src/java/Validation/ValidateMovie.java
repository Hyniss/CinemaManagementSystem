/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author NITRO
 */
public class ValidateMovie {

    //hàm check đầu vào cho movieName,categoryName, describe, author,actor
    public static boolean checkDataMovie(String data) {
        String regex = "^[-!@#$%^&*_,.;(){}\"':“”0-9a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪ\n"
                + "ẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễếệỉịọỏốồ\n"
                + "ổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{4,2000}(?:[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨ\n"
                + "ŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềề\n"
                + "ểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễếệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵ\n"
                + "ỷỹ]+){0,2}$";   // regex cho tên tiếng việt

        Pattern pattern = Pattern.compile(regex);   //biên dịch chuỗi chuỗi regex được tạo ra 
        Matcher matcher = pattern.matcher(data); //so sánh giá trị truyền vào với mẫu xem có trùng nhau không
        return matcher.matches(); //trả về true nếu giá trị truyền vào khớp nếu không sẽ trả về false
    }

    //hàm check đầu vào cho image
    public static boolean checkImage(String image) {
        String regex = "";   // regex cho tên tiếng việt

        Pattern pattern = Pattern.compile(regex);   //biên dịch chuỗi chuỗi regex được tạo ra 
        Matcher matcher = pattern.matcher(image); //so sánh giá trị truyền vào với mẫu xem có trùng nhau không
        return matcher.matches(); //trả về true nếu giá trị truyền vào khớp nếu không sẽ trả về false
    }

    //hàm check đầu vào cho duration phai la so và không bắt đầu bằng số 0
    public static boolean checkDuration(String duration) {
        String regex = "^[1-9][0-9]{1,2}$";   // regex cho tên tiếng việt

        Pattern pattern = Pattern.compile(regex);   //biên dịch chuỗi chuỗi regex được tạo ra 
        Matcher matcher = pattern.matcher(duration); //so sánh giá trị truyền vào với mẫu xem có trùng nhau không
        return matcher.matches(); //trả về true nếu giá trị truyền vào khớp nếu không sẽ trả về false
    }

    public static boolean checkTrailer(String trailer) {
        // regex cho url
        String regex = "^((http[s]?|ftp):\\/)?\\/?([^:\\/\\s]+)((\\/\\w+)*\\/)([\\w\\-\\.]+[^#?\\s]+)(.*)?(#[\\w\\-]+)?$";

        Pattern pattern = Pattern.compile(regex);   //biên dịch chuỗi chuỗi regex được tạo ra 
        Matcher matcher = pattern.matcher(trailer); //so sánh giá trị truyền vào với mẫu xem có trùng nhau không
        return matcher.matches(); //trả về true nếu giá trị truyền vào khớp nếu không sẽ trả về false
    }

}
