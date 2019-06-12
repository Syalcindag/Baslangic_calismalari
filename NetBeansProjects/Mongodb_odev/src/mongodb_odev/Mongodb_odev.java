/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodb_odev;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import static com.sun.scenario.Settings.set;

import java.util.Iterator;
import java.util.Scanner;

import javax.swing.text.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Sefa
 */
public class Mongodb_odev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secim;
        boolean bayrak = true;
        //connect
        MongoClient mc = new MongoClient("localhost", 27017);

        MongoCredential credential = MongoCredential.createCredential("sefa", "mongodb", "password".toCharArray());
        MongoDatabase mdb = mc.getDatabase("mongodb");
        MongoCollection<org.bson.Document> collection = mdb.getCollection("kayit");

        while (bayrak) {
            System.out.println("ANA MENU\n"
                    + "1-Listele\n"
                    + "2-Ekle\n"
                    + "3-Sil\n"
                    + "4-Guncelle\n"
                    + "0-Cikis\n"
                    + "Secim Yapiniz?\n");
            secim = scanner.nextInt();
            switch (secim) {
                case 1:
                    try {
                        System.out.println("---------------------------------------------");
                        FindIterable<Document> iterable;
                        iterable = (FindIterable<Document>) collection.find();
                        Iterator it = iterable.iterator();
                        while (it.hasNext()) {
                            System.out.println(it.next());
                        }
                    } catch (Exception e) {
                        System.out.println("");
                    }
                    break;
                case 2:
                    try {
                        int hocaNo;
                        String hocaAdi;
                        String hocaDogumYeri;
                        System.out.println("Hoca numarası giriniz : ");
                        hocaNo = scanner.nextInt();
                        System.out.println("Hoca adı giriniz : ");
                        hocaAdi = scanner.next();
                        System.out.println("Hoca dogum yeri giriniz : ");
                        hocaDogumYeri = scanner.next();
                        Document d;
                        d = new Document();
                        d.append("hNo", hocaNo)
                        d.append("hAdi", hocaAdi)
                        d.append("hDogumYeri", hocaDogumYeri);
                        collection.insertOne(d);
                    } catch (Exception e) {
                        System.out.println("");
                    }
                    System.out.println("--------------------------------");
                    System.out.println(hocaAdi + "  basarili bir sekilde eklendi. \n\n");
                    System.out.println("--------------------------------");
                    break;
                case 3:

                    System.out.println("Hoca No giriniz : ");
                    int dHocaNo = scanner.nextInt();
                    collection.deleteOne(Filters.eq("hNo", dHocaNo));
                    System.out.println(dHocaNo + "  no lu hoca silindi");

                    break;
                case 4:
                    try {
                        Bson filter = null;
                        Bson query = null;
                        int hocaNo;
                        String hocaAdi;
                        String hocaDogumYeri;
                        System.out.println("Hoca numarası giriniz : ");
                        hocaNo = scanner.nextInt();
                        System.out.println("Hoca adı giriniz : ");
                        hocaAdi = scanner.next();
                        System.out.println("Hoca dogum yeri giriniz : ");
                        hocaDogumYeri = scanner.next();
                        System.out.println("\n");
                        filter = eq("hNo", hocaNo);
                        query = combine(set("hAdi", hocaAdi), set("hDogumYeri", hocaDogumYeri));
                        collection.updateMany(filter, query);
                    } catch (Exception e) {
                        System.out.println("");
                    }

                    System.out.println("--------------------------------");
                    System.out.println(hocaAdi + "  basarili bir sekilde eklendi. \n\n");
                    System.out.println("--------------------------------");

                    break;
                case 0:
                    bayrak = false;
                    break;
            }
        }
    }

}
