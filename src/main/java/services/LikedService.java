package services;

import java.util.ArrayList;
import java.util.List;

import models.Liked;
import models.PK;

/**
 * 日報テーブルの操作に関わる処理を行うクラス
 */
public class LikedService extends ServiceBase {



    /**
     * idを条件に取得したデータをReportViewのインスタンスで返却する
     * @param id
     * @return 取得データのインスタンス
     */
    public Liked findOne(int reportid,int employeeid) {
        return (findOneInternal(reportid, employeeid));
    }

    /**
     * 画面から入力された日報の登録内容を元にデータを1件作成し、日報テーブルに登録する
     * @param rv 日報の登録内容
     * @return バリデーションで発生したエラーのリスト
     */
    public List<String> create(int reportid,int employeeid) {
        List<String> errors = new ArrayList<String>();
       /* if (errors.size() == 0) {
            LocalDateTime ldt = LocalDateTime.now();
            rv.setCreatedAt(ldt);
            rv.setUpdatedAt(ldt);*/
            PK pk=new PK();
            pk.setEmployeeId(employeeid);
            pk.setReportId(reportid);
            Liked liked=new Liked();
            liked.setPk(pk);
            createInternal(liked);



        //バリデーションで発生したエラーを返却（エラーがなければ0件の空リスト）
        return errors;
    }



    /**
     * idを条件にデータを1件取得する
     * @param id
     * @return 取得データのインスタンス
     */
    private Liked findOneInternal(int reportid,int employeeid) {
    	 PK pk=new PK();
         pk.setEmployeeId(employeeid);
         pk.setReportId(reportid);
        return em.find(Liked.class, pk);
    }

    /**
     * 日報データを1件登録する
     * @param rv 日報データ
     */
    private void createInternal(Liked rv) {

        em.getTransaction().begin();
        em.persist(rv);
        em.getTransaction().commit();

    }

    public List<String> delete(int reportid,int employeeid) {
        List<String> errors = new ArrayList<String>();
       /* if (errors.size() == 0) {
            LocalDateTime ldt = LocalDateTime.now();
            rv.setCreatedAt(ldt);
            rv.setUpdatedAt(ldt);*/
            PK pk=new PK();
            pk.setEmployeeId(employeeid);
            pk.setReportId(reportid);
            Liked liked=findOneInternal(reportid,employeeid);
            deleteInternal(liked);


        //バリデーションで発生したエラーを返却（エラーがなければ0件の空リスト）
        return errors;
    }
    private void deleteInternal(Liked rv) {

        em.getTransaction().begin();
        em.remove(rv);
        em.getTransaction().commit();

    }

}