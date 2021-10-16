package tests.day11;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01(){
        System.out.println(System.getProperty("user.home")); //C:\Users\Ali Osman
        //"C:\Users\Ali Osman\Desktop\hardAssert.png"
        // Masaustundeki bir dosya yolunun tum bilgisayarlarda sorunsuz calismasi icin
        // dosya yolunu ikiye ayiracagiz
        // 1. herkesin bilgisayarinda farkli olan kisim
        //  bu kismi bilgisayardan System.getProperty("user.home") kodu ile alabiliriz
        // 2. herkes icin ayni olan kisim
        //    bu kisim 1.maddedeki yolun devami seklinde olur
        // ornek masaustumuzdeki picture dosyasi icin yol kaydedelim
        String dosyaYolu = System.getProperty("user.home")+ "\\Desktop\\hardAssert.png";
        System.out.println("dosya yolumuz : "+dosyaYolu);
        System.out.println(Files.exists (Paths.get (dosyaYolu)));
        Assert.assertTrue(Files.exists (Paths.get (dosyaYolu)));

    }
}
