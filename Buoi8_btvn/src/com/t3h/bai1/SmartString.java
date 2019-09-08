package com.t3h.bai1;

import java.util.ArrayList;

public class SmartString {
    private String text;
    private ArrayList arrayList = new ArrayList();

    public SmartString(String text) {
        this.text = text;
    }

    public void filter(){
        text = text.replace("<![CDATA[","");
        text = text.replace("]]>","");
        int start = text.indexOf("<item>");
        String tieude = "<title>";
        int titleStart = text.indexOf(tieude);
        int titleEnd = text.indexOf("</title>");

        String link = "<link>";
        int linkStart = text.indexOf(link);
        int linkEnd = text.indexOf("</link>");

        String imgLink = "src=\"";
        int imgStart = text.indexOf(imgLink);
        int imgEnd = text.indexOf("\" /></a>");

        String date = "<pubDate>";
        int dateStart = text.indexOf(date);
        int dateEnd = text.indexOf("</pubDate>");

        while (start!= -1) {
            String Title = text.substring(titleStart+tieude.length(),titleEnd);
            String Link = text.substring(linkStart+link.length(),linkEnd);
            String ImgLink = text.substring(imgStart+imgLink.length(),imgEnd);
            String Date = text.substring(dateStart+date.length(),dateEnd);
            arrayList.add("Title: "+ Title);
            arrayList.add("Link: " + Link);
            arrayList.add("ImgLink: " + ImgLink);
            arrayList.add("Date: "+ Date + "\n");

            start = text.indexOf("<item>", start+1);
            titleStart = text.indexOf(tieude,titleStart+1);
            titleEnd = text.indexOf("</title>",titleEnd+1);

            linkStart = text.indexOf(link,linkStart+1);
            linkEnd = text.indexOf("</link>",linkEnd+1);

            imgStart = text.indexOf(imgLink,imgStart+1);
            imgEnd = text.indexOf("\" /></a>",imgEnd+1);

            dateStart = text.indexOf(date,dateStart+1);
            dateEnd = text.indexOf("</pubDate>",dateEnd+1);
        }
    }

    public void inDanhSachTinTuc(){
        for (int i = 0; i <arrayList.size() ; i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
