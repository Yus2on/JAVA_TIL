# commit convention

- feat: feature
- fix: bug-fix, fix-typo
- docs: documentation
- conf: configuration
- ci: Continuous Integration
- build: build
- BREAKING CHANGE(!): drop post /api/v1/posts/
  - POST /api/v1/posts/ -> PATCH /api/v2/posts/
  - 이런 크리티컬한 이슈가 생겼을 때 사용 
  - 다른 컨벤션과 다르게 대문자를 사용 

----------------

# Branch

- 가지 하나하나를 브랜치라고 함
- 어느 특정 시점에 분기점을 생성하고 독릭접으로 코드를 변경할 수 있도록 도와주는 모델

```sh
git branch -r # 리모트 브랜치 조회 
git branch -a # all flag. 로컬 레포와 리모트 레포에서 브랜치 조회 
```

- 리모트랑 접촉을 하지 않으면 인포메이션이 업데이트되지 않음 

## 브랜치 생성

```shell
git branch branchName
git branch tobey

git branch # 현재 브랜치 조회 
```

- 브랜치를 딴다 등의 표현 사용 



## 브랜치 변경

```shell
git checkout branchName # 브랜치를 갈아탐 
git checkout tobey
git branch # 현재 브랜치 조회 
```

- 브랜치를 갈아탄다 = 공간적 이동 
- 시간적 이동을 할땐 `checkout ` 뒤에 커밋ID 사용 



## 브랜치의 병합 

- 실험적인 기능이 들어가야 함 -> 기능 개발 및 테스트 후 -> 본 기능에 추가 
- ex) 

```shell
vi branch_practice.md

# branch tobey
git checkout tobey

# Filmography
## Spyder-Man
- 2002, Tobey Maguire

## Spyder-Man2
- 2004, Tobey Maguire

## Spyder-Man3
- 2007, Tobey Maguire

```

```shell
# branch master
git checkout master

cat branch_practice.md
# branch master 에서는 내용이 나오지 않음 

```

```shell
# master로 체크아웃
git checkout master

# branch master
git merge tobey
```

- master 혹은 main 브랜치인 상태에서 Tobey 브랜치의 내용을 끌어오는 것임

```shell
git branch -D tobey 
# -D : delete 
```

- 라이프사이클을 다 한 브랜치는 지울 필요가 있음. 내가 작업을 하고 있는 브랜치만 남겨두는 것이 좋음 -> 보통 머지를 하고 브랜치를 함
- 내가 어디에 있고 어디 있는 브랜치를 따서 작업할지 유의 필요 
- 거의 기능 개발이 완전히 끝났을 때 머지를 함

---------

### Cloud Service

- 클라우드는 비용과의 싸움 
  - *Cloud* Storage : 조회를 거의 하지 않고 변경되지 않는 것
  - *Hot* Storage : 자주 조회하고 내용 변경이 많은 것을 올려서 비용을 세이브 함 

--------------------

## 브랜치 충돌

- 하위 브랜치에서 작업하고 커밋까지 해뒀는데 `main` 브랜치 위에서 다른 작업 후 커밋을 했을 때는 자동 머지가 실패한다 
- 에러가 아니고 당연히 생기는 현상. 브랜치를 따서 작업 하고 머지하려 했는데 전에 알던 상태가 아니라서 `CONFLICT` 발생
- 해결하기 위해선 해당 파일을 열어봐야 함 -> 동작하는 완벽한 상태를 만들고 저장 

```shell
<<<<<<<< HEAD
# main 작업 내용 
=========
# 하위 브랜치 작업 내용 
>>>>>>>>> 하위 브랜치
```

- `HEAD` 는 내가 지금 머지를 하려고 할 때 당겨오려고 햇던 브랜치고, 언제나 메인이나 마스터는 아님 

```shell
git status
# both modified: 작업 파일 이름 
git add 
git commit
git push origin main
```

- commit 하면 `Merge branch '브랜치명'into main ` 이라고 이미 채워져 있는 상태 

-------------

## branching models

- git flow
  - 제일 많이 쓰임 
  -  `main` - Develop - Feature -  Feature
  - main : 사용자가 사용하게 될 최종, 완성 단계의 코드 
  - Develop : 다음 배포판을 위해서 작업하게 될 단계
  - Feature : Develop에서 특정 기능 추가를 위해 새로 따서 작업 후 기능 완료 되면 Feature 를 닫음 
- github flow
  - git flow가 조금 더 최적화 된 모델 
- gitlab flow
  - git flow가 조금 더 최적화 된 모델 

<br>

```shell
# git flow setup
$ brew install git-flow-avh
```

### git flow 설치 여부 확인 

```shell
$ git flow 
# command list 가 출력된다면 설치가 되어있는 것 
```

<br>

## git flow

```shell
$ git init

$ git flow init
# [] 안에 내용이 비어있다면 master라고 쓰고 채워져 있다면 엔터 
# 이후에 큰 상관이 없으면 $ 표시가 보일 때까지 엔터 
# develop 브랜치로 자동 이동 

$ git branch
# * develop
#   master 

# develop 브랜치에서 새로운 기능 개발을 할 때 아래 명령어 사용
# 브랜치를 따고 이동하는 것까지 수행 
$ git flow feature start featureName 

# 브랜치 내 기능이 완료가 된다면 브랜치를 닫기
$ git flow feature finish featureName

```

