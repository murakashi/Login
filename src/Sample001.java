import java.text.SimpleDateFormat;
import java.util.Date;

public class Sample001 {

	public static void main(String[] args) {

		Date date = new Date();

		//フォーマットパターンを指定して表示する
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        System.out.println(sdf.format(date.getTime()));

        //System.out.println(sdf.format(date.toString()));


	}

}
