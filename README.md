# QUẢN LÝ BUS

Viết chương trình Quản lý nhân viên nhà xe & Quản lý vé xe Bus

## A. Quản lý nhân viên nhà xe

### 1. Tạo **abstracts class** `Employee` với **5 thuộc tính**:

    - `id`: String (mã nhân viên)
    - `name`: String (tên nhân viên)
    - `position`: String (chức vụ)
    - `workDays`: int (số ngày làm việc)
    - `daySalary`: double (tiền lương 1 ngày)

### 2. Tạo **5 class con** kế thừa từ class `Employee`:

    - `NormalEmployee` (nhân viên thường => lương * 1.0);
    - `FareController` (soát vé => lương * 1.1);
    - `Driver` (lái xe => lương * 1.5);
    - `RouteManager` (quản lý tuyến => lương * 2.0);
    - `Director` (giám đốc => lương * 4.0)

### 3. Tạo class `EmployeesManager` để quản lý nhân viên:

    - **Thuộc tính**: `ArrayList` chứa thông tin các nhân viên
    - **Phương thức**: 15 chức năng
        - **Thêm**, **Sửa**, **Xóa** thông tin `nhân viên` (3 chức năng)
        - **Hiển thị** thông tin nhân viên theo từng `chức vụ` (6 chức năng)
        - **Đọc & Ghi** thông tin nhân viên vào `text file` 
        - **Tính toán & Hiển thị** `totalSalary` của toàn nhân viên trong công ty (1 chức năng)
        - **Tìm kiếm** nhân viên theo `id` & `name` (2 chức năng)
        - **Ghi** thông tin của 5 nhân viên có `lương` cao nhất `text file` (1 chức năng)
        - **Hiển thị** thông tin nhân viên có `lương cao nhất` và `lương thấp thứ 2` (2 chức năng)

## B. Quản lý vé xe bus

### 1. Tạo **abstracts class** `Ticket` với **5 thuộc tính**:
    
    - `id`: String (mã vé)
    - `route`: int (tuyến xe bus)
    - `type`: String (loại vé)
    - `roundTrip`: boolean (vé khứ hồi => giá vé x2)
    - `price`: double (giá vé)

### 2. Tạo **5 class con** kế thừa từ class `Ticket`:
    
    - `NormalNormalTicket` (vé thường => giá * 1)
    - `StudentTicket` (vé học sinh => giá * 0.7)
    - `SeniorTicket` (vé người già => giá * 0.5)
    - `DailyTicket` (vé ngày => giá * 1.5);
    - `MonthlyTicket` (vé tháng => giá * 0.5 * 30)

### 3. Tạo class `TicketsManager` để quản lý vé xe:
    
    - **Thuộc tính**: `ArrayList` chứa thông tin các vé xe đã bán
    - **Phương thức**: 13 chức năng
        - **Thêm**, **Sửa**, **Xóa** thông tin `vé xe` (3 chức năng)
        - **Hiển thị** thông tin vé xe theo `loại vé` (6 chức năng)
        - **Đọc & Ghi** thông tin vé xe vào `text file` 
        - **Tính toán & Hiển thị** `tống số tiền bán vé` (1 chức năng)
        - **Ghi** thông tin của 5 vé xe có `giá` thấp nhất `binary file` (1 chức năng)
        - **Sắp xếp * Hiển thị** theo giá tăng dần và giảm dần (2 chức năng)