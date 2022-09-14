package com.duing.util;
import nl.siegmann.epublib.domain.*;
import nl.siegmann.epublib.epub.EpubReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

public class EpubUtil {
    public static void main(String[] args) {
        File file  = new File("epub/三体.epub");
        System.out.println(file.getAbsolutePath());
        EpubReader reader = new EpubReader();
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            Book book = reader.readEpub(in);
            System.out.println(book.getTitle());
            Metadata metadata = book.getMetadata();
//            List<Author> authors = metadata.getAuthors();
//            System.out.println(authors.get(0).toString());
            Resources resources = book.getResources();
            Collection<Resource> resourceCollection = resources.getAll();
            for (Resource resource : resourceCollection) {
                System.out.println(resource);
            }
            System.out.println("==============================================================================================================");
            System.out.println(resources.size());
            //获取脊梁
            Spine spine = book.getSpine();
            System.out.println(spine.size());
            List<SpineReference> spineReferences = spine.getSpineReferences();
            for (SpineReference spineReference : spineReferences) {
                Resource resource = spineReference.getResource();
                //获取到资源 ，字体，样式，图片，文本信息
                MediaType type = resource.getMediaType();
                System.out.println(type.getName());
                System.out.println(resource.getHref());

                //获取文本内容
                resource.getData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
