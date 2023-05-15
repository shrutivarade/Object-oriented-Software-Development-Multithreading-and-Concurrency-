package edu.umb.cs681.hw10;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class TestFixture{



    static private LocalDateTime ldt = LocalDateTime.now();

    Directory root = new Directory(null,"root", 0, ldt);
    Directory Apps = new Directory(root,"Apps", 0, ldt);
    File file_x = new File(Apps,"file_x",1,ldt);
    Directory bin = new Directory(root,"bin", 0, ldt);
    File file_y = new File(bin,"file_y",2,ldt);
    Directory home = new Directory(root,"home", 0, ldt);
    File file_c = new File(home,"file_c",3,ldt);
    Directory pictures = new Directory(home,"pictures", 0, ldt);
    File file_a = new File(pictures,"file_a",4,ldt);
    File file_b = new File(pictures,"file_b",5,ldt);
    Link link_d = new Link(root, "link_d", 6, ldt, pictures);
    Link link_e = new Link(root, "link_e", 7, ldt, file_x);


    FileSystem createTextFixture() {

        root.appendChild(Apps);
        root.appendChild(bin);
        root.appendChild(home);
        root.appendChild(link_d);
        root.appendChild(link_e);

        Apps.appendChild(file_x);

        bin.appendChild(file_y);

        home.appendChild(pictures);
        home.appendChild(file_c);

        pictures.appendChild(file_a);
        pictures.appendChild(file_b);

        link_d.setSize(6);
        link_e.setSize(7);

        FileSystem fs = FileSystem.getFileSystem();
        fs.appendRootDirs(root);
        return fs;

    }




}
