# Product Order Web - Spring Boot Maven

## Chạy project

```bash
mvn spring-boot:run
```

Mở:
https://shopadmin-28kb.onrender.com
WEBSITE có 2 trang: User và Admin.
User: Đặt hàng.
Admin: Quản lý sản phẩm(thêm, sửa, xóa), danh sách sản phẩm, chi tiết sản phẩm, quản lý đơn đặt hàng.

## Cấu hình Neon

```bash
set DB_URL=jdbc:postgresql://ep-cold-art-aqmb1f8j-pooler.c-8.us-east-1.aws.neon.tech/neondb?sslmode=require&channelBinding=require
set DB_USERNAME=neondb_owner
set DB_PASSWORD=npg_FMHiN12ojpKw
mvn spring-boot:run
```
