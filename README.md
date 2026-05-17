# Product Order Web - Spring Boot Maven

## Chạy project

```bash
mvn spring-boot:run
```

Mở:
- User mua hàng: http://localhost:8080/products
- Admin quản lí sản phẩm: http://localhost:8080/admin/products
- Admin xem đơn hàng: http://localhost:8080/admin/orders

## Cấu hình Neon

```bash
set DB_URL=jdbc:postgresql://ep-cold-art-aqmb1f8j-pooler.c-8.us-east-1.aws.neon.tech/neondb?sslmode=require&channelBinding=require
set DB_USERNAME=neondb_owner
set DB_PASSWORD=npg_FMHiN12ojpKw
mvn spring-boot:run
```
