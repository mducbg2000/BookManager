# Hướng dẫn sử dụng :computer:
## 1. Môi trường :earth_asia:
* <a href="https://tutorials.visualstudio.com/Java/hello-world/install-jdk">JDK 1.8</a>
* <a href="https://www.baeldung.com/tomcat">Tomcat 8.5</a>
* <a href="https://tutorials.visualstudio.com/Java/hello-world/install-maven">Maven</a>
* <a href="https://downloads.mysql.com/archives/installer/">MySQL 8.0.21</a> (bản khác cũng được nhưng phải sửa version trong file pom.xml)
```
        <!-- MySQL -->
        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.21</version>
        </dependency>
```

## 2. Cài đặt :hammer_and_wrench:
* Clone project về (giải nén nếu download file zip), mở bằng IDE (tốt nhất là <a href="https://icongnghe.com/jetbrains-intellij-idea-ultimate-2020/">*Intellij Ultimate*</a> hoặc <a href="https://viblo.asia/p/cai-dat-va-cau-hinh-java-ee-cho-eclipse-924lJ4oaKPM">*Eclipse EE*</a>, ko khuyến khích mở bằng *Netbean*)

## 3. Tạo db :floppy_disk:
* Dùng *MySQL Workbench* hoặc *DataGrip* hoặc bất kỳ studio nào kết nối tới cơ sở dữ liệu MySQL ở localhost để
`Execute` file db_05.sql để tạo db (open file hoặc copy script)
* Nếu không thích tạo user mới (test123), có thể tự dùng bất cứ user nào khác (root,...), tuy nhiên phải sửa 2 thuộc tính sau trong file hibernate.cfg.xml
```
        <property name="connection.username">test123</property>
        <property name="connection.password">test123</property>
``` 

## 4. Add dependency :arrow_forward:
* Chạy *Maven* để load dependency cho project (Intellij Và Eclipse EE đều hỗ trợ việc này trong 1-2 cú click chuột, Netbean không biết)

## 5. Run project :rocket:
* Deploy project trên Tomcat rồi chạy (tương tự maven, Intellij Và Eclipse EE cũng đều hỗ trợ việc này trong 1-2 cú click chuột, Netbean cũng không biết)
## 6. Lưu ý :warning:
* File script *db_05.sql* khi bôi đen toàn bộ rồi `Execute` có thể bị lỗi dòng cuối cùng để cấp quyền cho test123, có thể bôi đen dòng cuối để chạy `Execute` lại, hoặc tốt nhất `Execute` từng lệnh một
* Database không có data, có thể tự add tay hoặc chạy project rồi add thông qua webapp, có các chức năng đăng nhập, đăng ký, book thì có đủ CRUD
* JSP render ra html lần đầu tiên khá lâu, thỉnh thoảng chưa load được sẽ hiện lỗi nhưng thực ra không phải, ấn `F5` vài phát là được
* Nếu có chức năng nào đó không thực hiện được và throw exception thì có thể back lại để thử các chức năng khác, chương trình vẫn chạy, không cần chạy lại
## 7. Vui lòng liên hệ <a href="https://www.facebook.com/mducbg2000/"> nhóm trưởng </a> :crocodile: nếu không chạy được hoặc có bất kỳ thắc mắc nào :telephone_receiver:
