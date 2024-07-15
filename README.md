# 🏥 UBIS동물병원에 오신걸 환영합니다

## 프로젝트 개요

이 프로젝트는 동물병원을 위한 반려동물 관리 시스템입니다. 데이터베이스 연동 없이 Java를 사용하여 CRUD(Create, Read, Update, Delete) 기능을 구현하였습니다. 사용자는 반려동물의 정보와 질병 관련 데이터를 관리할 수 있습니다.

## 주요 기능

- **반려동물 관리 (Animal)**: 반려동물의 기본 정보를 저장하고 관리합니다.
- **질병 관리 (Disease)**: 질병의 정보를 관리하고, 해당 질병에 따른 요금을 설정합니다.
- **의료 기록 관리 (MedicalRecord)**: 각 반려동물의 진료 기록을 관리합니다.
- **충전 금액 관리**: 각 반려동물에 대해 충전된 금액에서 진료비를 차감할 수 있습니다.

## 클래스 구조

### Animal 클래스

| 속성               | 설명                     |
|--------------------|--------------------------|
| `petId`            | 동물의 고유 ID          |
| `petName`          | 반려동물 이름           |
| `guardianName`     | 보호자 성함             |
| `animalType`       | 동물 종류               |
| `chargeAmount`     | 충전 금액               |
| `gender`           | 반려동물 성별           |
| `diseases`         | 질병 리스트 (Disease)   |
| `medicalRecords`   | 의료 기록 리스트 (MedicalRecord) |

### Disease 클래스

| 속성         | 설명                 |
|--------------|----------------------|
| `diseasePK`  | 질병의 고유 ID      |
| `diseaseName`| 질환명              |
| `fee`        | 진료 요금           |

### MedicalRecord 클래스

| 속성            | 설명                 |
|-----------------|----------------------|
| `pk`            | 진료 기록의 고유 ID  |
| `disease`       | 질병 정보 (Disease)  |
| `animalPK`      | 관련된 동물의 ID     |
| `updateDate`    | 진료 업데이트 날짜   |
| `totalFee`      | 총 진료비           |
| `doctorName`    | 담당 의사           |

<img src="https://github.com/user-attachments/assets/7fe773fd-4088-4bdc-aae7-382ea2523ab4" alt="ClassDiagram" width="600">

## 사용 방법

1. **반려동물 추가**: 새로운 반려동물 정보를 입력하여 추가합니다.
2. **진료 기록 추가**: 반려동물의 진료 기록을 추가합니다.
3. **충전 금액 차감**: 진료를 받을 때, 해당 질병의 요금을 충전 금액에서 차감합니다.




