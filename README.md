# Mobil Araç Kiralama Uygulaması - Proje ve Test Otomasyonu

Bu proje, prestijli bir holdingin araç kiralama sektörüne giriş yapma planları doğrultusunda geliştirilecek olan mobil araç kiralama uygulamasının kapsamlı analizini ve test otomasyonu çalışmalarını içermektedir.

## Proje İçeriği

### 1. Benchmarking (Pazar Araştırması)
- Yerel ve global alandaki önde gelen mobil araç kiralama uygulamaları incelendi. Bu analiz sonucunda, müşteri deneyimi, güvenlik ve kullanıcı dostu arayüz gibi konularda öne çıkan özellikler belirlendi. Şirketimizin bu pazarda rakiplerinden ayrışmasını sağlayacak özellikler tespit edilip sunum hazırlandı.

### 2. Kapsam ve Temel Özellikler
- Zaman ve maliyet kısıtları dikkate alınarak, uygulamada yer alacak 10 temel özellik ve ilerleyen süreçte eklenebilecek 5 ekstra geliştirme belirlendi. Bu özellikler önceliklendirilerek proje kapsamı oluşturuldu.

### 3. Backlog Yönetimi (MVP ve Tasklar)
- Proje üç ayrı MVP (Minimum Viable Product) olarak planlandı. Her MVP için en kritik 10 backlog item belirlendi ve bu item’lar için minimum ikişer görev tanımlandı. İş yükü, MVP’ler arasında dengeli bir şekilde dağıtıldı.

### 4. Zaman Yönetimi (Time Management)
- Projenin 9 aylık bir süreçte, Eylül 2024 – Haziran 2025 tarihleri arasında tamamlanması planlandı. Bu süreçte her MVP için ayrılan süreler ve kritik aşamalar detaylandırılarak zaman çizelgesi oluşturuldu.

### 5. Use Case Methodology
- Projenin detayları 50 adet requirement ile yapılandırıldı. Bu requirementlar, Who-Why-What sorularını cevaplayacak şekilde Use Case Methodology ile hazırlandı, böylece projenin işlevselliği ve kullanıcı ihtiyaçlarına uygunluğu sağlandı.

### 6. UML Diagramları
- Uygulamanın genel çalışma akışını ve bileşenler arası ilişkileri görselleştirmek amacıyla UML diagramları oluşturuldu. Bu diagramlar, geliştirme sürecini ve müşteri tarafından anlaşılabilirliği desteklemek için kullanıldı.

### 7. Mock Up ve UI/UX Prototipleri
- LOGIN, LOGOUT ve SIGNUP süreçleri için kullanıcı dostu arayüz ve optimum kullanıcı deneyimi (UI/UX) prensiplerine uygun mock-up'lar hazırlandı. Bu prototipler, JustInMind ve Balsamiq gibi araçlar kullanılarak tasarlandı.

### 8. Analiz Dokümanı ve Veritabanı Yönetimi
- SIGN UP süreci için bir analiz dokümanı oluşturuldu. Bu dokümanda, veritabanında tutulması gereken veri başlıkları, veri tipleri ve foreign key'ler belirtildi. Ayrıca, tabloda yapılacak olası değişikliklerin nasıl yönetileceği alternatif çözüm yolları ile tartışıldı.

### 9. Demo
- Uygulamanın LOGIN, LOGOUT ve SIGNUP süreçlerini kapsayan bir demo hazırlandı. Bu demo, müşteriye sunulmak üzere geliştirilen uygulamanın işleyişini canlı olarak gösterdi.

### 10. Migration ve API Uygulaması
- Halihazırda başka bir uygulamayı kullanan 50 bin kişilik müşteri kitlesinin yeni uygulamaya geçişi için bir aksiyon planı oluşturuldu. Ayrıca, müşterilerin ehliyet bilgilerini Emniyet Genel Müdürlüğü sistemi üzerinden doğrulama süreci için çözümler geliştirildi.

### 11. KVKK Kapsamında Güvenlik
- KVKK kapsamında, müşteri verilerine erişimi sınırlandırmak ve üretim ortamında iz bırakmamak için çeşitli güvenlik alternatifleri araştırıldı. Bu alternatifler arasında tabloya kişi bazlı erişim yetkisi verilmesi ve loglama uygulamaları yer aldı.

### 12. Veri Madenciliği ve SQL Kullanımı
- Kayıtlı müşteri veri tabanından, 20-22 yaş arasında olup Haziran ayında sisteme kayıt olmuş müşterilerin sayısı çıkarıldı. Bu veri madenciliği işlemi, uygulamanın analiz süreçlerinde kullanılmak üzere SQL sorguları ile gerçekleştirildi.

## Test Otomasyonu

Proje kapsamında geliştirilen test senaryoları `Cucumber` kullanılarak yazıldı. Bu testler, uygulamanın kritik süreçlerinin doğruluğunu ve güvenilirliğini sağlamak amacıyla hazırlandı. Ayrıca, demo ekranında bu senaryolar çalıştırıldı ve başarıyla tamamlandı.
