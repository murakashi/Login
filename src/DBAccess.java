import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class DBAccess {

	String sql;

	String data;

	Connection objCon;

	public DBAccess() {
		try {
			//JDBCドライバを設定する
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			//データベース名、ユーザ名、パスワード
			String connUrl = "jdbc:sqlserver://STRA-CL0061\\SQLEXPRESS2012;database=DBENSYU;" +
					"integratedSecurity=false;user=sa;password=Step2154822";

			//接続開始
			objCon = DriverManager.getConnection(connUrl);//
		} catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
			System.out.println(sql);
		}
	}

	/*******************ログインメソッド***************************************************/
	public ArrayList<String[]> login(String id, String pass) {

		//クエリ取得
		sql = "select * from user_table where ID = '" + id + "' and パスワード = '" + pass + "'";

		//selectした結果を格納する用
		ArrayList<String[]> list = new ArrayList<String[]>();

		try {
			//Statement生成
			Statement stmt = objCon.createStatement();

			//問い合わせの実行
			ResultSet rs = stmt.executeQuery(sql);

			//結果の取得
			while (rs.next()) {
				String[] recdata = new String[4];
				recdata[0] = rs.getString("ID");
				recdata[1] = rs.getString("パスワード");
				recdata[2] = rs.getString("氏名");
				recdata[3] = rs.getString("住所");
				list.add(recdata);
				break;
			}
			rs.close();
			stmt.close();
		} catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
		}
		return list;
	}


	/**********************権限を返す********************************/
	public String get_Kengen(String id, String pass) {

		//クエリ取得
		sql = "select 権限 from user_table2 where ID = '" + id + "' and パスワード = '" + pass + "'";

		//selectした結果を格納する用
		String kengen=null;

		try {
			//Statement生成
			Statement stmt = objCon.createStatement();

			//問い合わせの実行
			ResultSet rs = stmt.executeQuery(sql);

			//結果の取得
			while (rs.next()) {
				kengen = rs.getString("権限");
				break;
			}
			rs.close();
			stmt.close();
		} catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
		}
		return kengen;
	}

	/***********************インサートメソッド**************************************/
	public int insert(String id, String pass, String name, String adress) {

		sql = "insert into user_table values('"+ id +"','"+ pass +"','"+ name +"','"+ adress +"')";

		int result = 0;

		try {
			//リザルトセット
			Statement stms = objCon.createStatement();

			result = stms.executeUpdate(sql);

			objCon.close();
			stms.close();

		}catch (SQLServerException e) {
			return 0;
		}
		catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
		}
		return result;
	}

	/***********************アップデートメソッド**************************************/
	public int update(String id, String pass, String name, String adress) {

		sql = "update user_table set ID = '"+ id +"',パスワード = '"+ pass +"'"
			+ ",氏名 = '"+ name +"',住所 = '"+ adress +"' "
			+ "where ID = '"+ id +"'";

		int result = 0;

		try {
			//リザルトセット
			Statement stms = objCon.createStatement();

			result = stms.executeUpdate(sql);

			objCon.close();
			stms.close();

		}catch (SQLServerException e) {
			return 0;
		}
		catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
		}
		return result;
	}

	/****************商品マスタから全件セレクトする*************************/
	public ArrayList<String[]> select_Syohin() {

		//クエリ取得
		sql = "select * from 商品マスタ";

		//selectした結果を格納する用
		ArrayList<String[]> list = new ArrayList<String[]>();

		try {
			//Statement生成
			Statement stmt = objCon.createStatement();

			//問い合わせの実行
			ResultSet rs = stmt.executeQuery(sql);

			//結果の取得
			while (rs.next()) {
				String[] recdata = new String[3];
				recdata[0] = rs.getString("商品ID");
				recdata[1] = rs.getString("商品名");
				recdata[2] = rs.getString("単価");
				list.add(recdata);
			}
			rs.close();
			stmt.close();
		} catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
		}
		return list;
	}


	/****************商品マスタから最初の20行セレクトする*************************/
	public ArrayList<String[]> select_SyohinTop() {

		//クエリ取得
		sql = "select top 20 * from 商品マスタ";

		//selectした結果を格納する用
		ArrayList<String[]> list = new ArrayList<String[]>();

		try {
			//Statement生成
			Statement stmt = objCon.createStatement();

			//問い合わせの実行
			ResultSet rs = stmt.executeQuery(sql);

			//結果の取得
			while (rs.next()) {
				String[] recdata = new String[3];
				recdata[0] = rs.getString("商品ID");
				recdata[1] = rs.getString("商品名");
				recdata[2] = rs.getString("単価");
				list.add(recdata);
			}
			rs.close();
			stmt.close();
		} catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
		}
		return list;
	}

	/****************商品マスタから次の20行をセレクトする*************************/
	public ArrayList<String[]> select_SyohinNext(String offset) {

		//クエリ取得
		sql = "select * from 商品マスタ order by 商品ID offset "+ offset +
			  " rows fetch next 20 rows only";

		//selectした結果を格納する用
		ArrayList<String[]> list = new ArrayList<String[]>();

		try {
			//Statement生成
			Statement stmt = objCon.createStatement();

			//問い合わせの実行
			ResultSet rs = stmt.executeQuery(sql);

			//結果の取得
			while (rs.next()) {
				String[] recdata = new String[3];
				recdata[0] = rs.getString("商品ID");
				recdata[1] = rs.getString("商品名");
				recdata[2] = rs.getString("単価");
				list.add(recdata);
			}
			rs.close();
			stmt.close();
		} catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
		}
		return list;
	}

	/****************購入履歴CからIDを指定して日付昇順の上位20件をセレクトする*************************/
	public ArrayList<String[]> select_Log(String id) {

		//クエリ取得
		sql = "select top 20 購入連番,日時,商品名,数量,(数量*単価) as 金額 from "
			+ "商品マスタ inner join 購入履歴C "
			+ "on 商品マスタ.商品ID = 購入履歴C.商品ID "
			+ "inner join user_table "
			+ "on user_table.ID = 購入履歴C.ID "
			+ "where 購入履歴C.ID = '"+ id +"' "
			+ "and 削除フラグ = '0' "
			+ "order by 日時";

		//selectした結果を格納する用
		ArrayList<String[]> list = new ArrayList<String[]>();

		try {
			//Statement生成
			Statement stmt = objCon.createStatement();

			//問い合わせの実行
			ResultSet rs = stmt.executeQuery(sql);

			//結果の取得
			while (rs.next()) {
				String[] recdata = new String[5];
				recdata[0] = rs.getString("購入連番");
				recdata[1] = rs.getString("日時");
				recdata[2] = rs.getString("商品名");
				recdata[3] = rs.getString("数量");
				recdata[4] = rs.getString("金額");
				list.add(recdata);
			}
			rs.close();
			stmt.close();
		} catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
		}
		return list;
	}

	/****************購入履歴CからIDを指定して次の20件をセレクトする*************************/
	public ArrayList<String[]> select_LogNext(String id,String offset) {

		//クエリ取得
		sql = "select 購入連番,日時,商品名,数量,(数量*単価) as 金額 from "
			+ "商品マスタ inner join 購入履歴C "
			+ "on 商品マスタ.商品ID = 購入履歴C.商品ID "
			+ "inner join user_table "
			+ "on user_table.ID = 購入履歴C.ID "
			+ "where 購入履歴C.ID = '"+ id +"' "
			+ "and 削除フラグ = '0' "
			+ "order by 日時 offset "+ offset +" rows fetch next 20 rows only";

		//selectした結果を格納する用
		ArrayList<String[]> list = new ArrayList<String[]>();

		try {
			//Statement生成
			Statement stmt = objCon.createStatement();

			//問い合わせの実行
			ResultSet rs = stmt.executeQuery(sql);

			//結果の取得
			while (rs.next()) {
				String[] recdata = new String[5];
				recdata[0] = rs.getString("購入連番");
				recdata[1] = rs.getString("日時");
				recdata[2] = rs.getString("商品名");
				recdata[3] = rs.getString("数量");
				recdata[4] = rs.getString("金額");
				list.add(recdata);
			}
			rs.close();
			stmt.close();
		} catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
		}
		return list;
	}

	/****************購入履歴Cから購入連番の最大値+1をセレクトする*************************/
	public String select_Max() {

		//クエリ取得
		//sql = "select max(購入連番)+1 as 自動採番 from 購入履歴B";
		sql = "select max(isnull(購入連番, 0))+1 as 自動採番 from 購入履歴C";

		//selectした結果を格納する用
		String max = new String();

		try {
			//Statement生成
			Statement stmt = objCon.createStatement();

			//問い合わせの実行
			ResultSet rs = stmt.executeQuery(sql);

			//結果の取得
			while (rs.next()) {
				max = rs.getString("自動採番");
				break;
			}
			rs.close();
			stmt.close();
		} catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
		}
		return max;
	}

	/***********************購入履歴Cにインサートする**************************************/
	public int insert_Log(String max, String id,String s_id,String count,String date) {

		sql = "insert into 購入履歴C values("+ max +",'"+ id +"','"+ s_id +"',"+ count +",'"+ date +"','0')";

		int result = 0;

		try {
			//リザルトセット
			Statement stms = objCon.createStatement();

			result = stms.executeUpdate(sql);

			//objCon.close();
			//stms.close();

		}catch (SQLServerException e) {
			return 0;
		}
		catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
		}
		return result;
	}

	/***********************購入履歴CからIDを指定して削除フラグを更新する**************************************/
	public int delete_Log(String num) {

		sql = "update 購入履歴C set 削除フラグ = '1' where 購入連番 = '"+ num +"'";

		int result = 0;

		try {
			//リザルトセット
			Statement stms = objCon.createStatement();

			result = stms.executeUpdate(sql);

			//objCon.close();
			//stms.close();

		}catch (SQLServerException e) {
			return 0;
		}
		catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
		}
		return result;
	}

	/****************管理者用ページに表示するデータを抽出する*************************/
	public ArrayList<String[]> select_buyList() {

		//クエリ取得
		/*sql = "select 氏名,商品名,単価,数量,(数量*単価) as 金額 " +
				"from user_table inner join 購入履歴C " +
				"on user_table.ID = 購入履歴C.ID " +
				"inner join 商品マスタ " +
				"on 購入履歴C.商品ID = 商品マスタ.商品ID "+
				"order by 数量 desc";
		*/
		sql ="select 氏名,商品名,単価,数量,(数量*単価) as 金額 " +
				"from user_table inner join 購入履歴C " +
				"on user_table.ID = 購入履歴C.ID " +
				"inner join 商品マスタ " +
				"on 購入履歴C.商品ID = 商品マスタ.商品ID " +
				"order by 数量 desc";
		//selectした結果を格納する用
		ArrayList<String[]> buy_list = new ArrayList<String[]>();

		try {
			//Statement生成
			Statement stmt = objCon.createStatement();

			//問い合わせの実行
			ResultSet rs = stmt.executeQuery(sql);

			//結果の取得
			while (rs.next()) {
				String[] recdata = new String[5];
				recdata[0] = rs.getString("氏名");
				recdata[1] = rs.getString("商品名");
				recdata[2] = rs.getString("単価");
				recdata[3] = rs.getString("数量");
				recdata[4] = rs.getString("金額");
				buy_list.add(recdata);
			}
			rs.close();
			stmt.close();
		} catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
		}
		return buy_list;
	}

	/****************管理者用ページに表示する合計金額を抽出する*************************/
	public String get_Sum() {

		//クエリ取得
		sql = "select sum((数量*単価)) as 合計 " +
				"from user_table inner join 購入履歴C " +
				"on user_table.ID = 購入履歴C.ID " +
				"inner join 商品マスタ " +
				"on 購入履歴C.商品ID = 商品マスタ.商品ID";

		String sum = null;

		//selectした結果を格納する用
		ArrayList<String[]> buy_list = new ArrayList<String[]>();

		try {
			//Statement生成
			Statement stmt = objCon.createStatement();

			//問い合わせの実行
			ResultSet rs = stmt.executeQuery(sql);

			//結果の取得
			while (rs.next()) {
				sum = rs.getString("合計");
			}
			rs.close();
			stmt.close();
		} catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
		}
		return sum;
	}

	/****************商品ごとに表示するデータを抽出する*************************/
	public ArrayList<String[]> select_groupList() {

		//クエリ取得
		sql = "select 商品名,単価,sum(数量) as 数量,sum((数量*単価)) as 金額 " +
				"from 購入履歴C inner join 商品マスタ " +
				"on 購入履歴C.商品ID = 商品マスタ.商品ID " +
				"group by 商品名,単価 "+
				"order by 金額 desc";

		//selectした結果を格納する用
		ArrayList<String[]> group_list = new ArrayList<String[]>();

		try {
			//Statement生成
			Statement stmt = objCon.createStatement();

			//問い合わせの実行
			ResultSet rs = stmt.executeQuery(sql);

			//結果の取得
			while (rs.next()) {
				String[] recdata = new String[4];
				recdata[0] = rs.getString("商品名");
				recdata[1] = rs.getString("単価");
				recdata[2] = rs.getString("数量");
				recdata[3] = rs.getString("金額");
				group_list.add(recdata);
			}
			rs.close();
			stmt.close();
		} catch (Exception objEx) {
			//コンソールに「接続エラー内容」を表示
			System.err.println(objEx.getClass().getName() + ":" + objEx.getMessage());
		}
		return group_list;
	}

}
