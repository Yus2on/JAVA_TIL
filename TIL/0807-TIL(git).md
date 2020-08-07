# git

## Characteristics of git

- 빠른속도, 단순한 구조
- **분산형 저장소 지원** 
- **비선형적 개발(수천개의 브랜치) 가능**



## git Process and Command

![git process](https://camo.githubusercontent.com/6101a2b0f170b0a22db8b1077bfa2c6d7fb172bf/68747470733a2f2f692e737461636b2e696d6775722e636f6d2f4d676156392e706e67)





## git is not equal to github

![](https://camo.githubusercontent.com/2e66f084706a7257430210a85c45191cc4d6876b/687474703a2f2f312e62702e626c6f6773706f742e636f6d2f2d57593259704e72335736672f555936745a41632d4833492f4141414141414141424c592f784a3978337749593856382f73313630302f476974687562322e706e67)





## 

## git을 시작하기 전 해야할 작업

> - git을 본격적으로 사용하기 전 github username과 email, 사용할 Editor를 설정 필요.
> - 위치는 상관 없음

```` shell
$ git config --global --unset core.pager # git config --list d이름, 이메일 수정 
$ git config --global user.name "{github username}"
$ git config --global user.email "{github email address}"
$ git config --global core.editor "vim"
$ git config --global core.pager "cat"
$ git config --list
````

config 작업이 끝났다면 , `$ git config --list`  명령으로 메일주소와 유저네임 오탈자 확인 필요



### git repository LICENSE

가장 많이 사용하는 License 

1. MIT License
   - MIT에서 만든 라이센스로, 모든 행동에 제약이 없으며, 저작권자는 소프트웨어와 관련한 책임에서 자유롭다.
2. Apache License 2.0
   - Apache 재단이 만든 라이센스로, 특허권 관련 내용이 포함.

3. GNU General Public License v3.0 (GPL)
   - 가장 많이 알려져있지만 의무사항(해당 라이센스가 적용된 소스코드 사용시 GPL을 따라야 함)이 존재.



## git 

```` shell
$ git status # 라인 단위로 파일의 상태를 체크할 수 있음
$ git add fileName 
$ git commit
# editor을 vim으로 설정해뒀기 때문에 vim으로 열린다
# git commit -m 을 하면 한 줄로 가능
````

>vim으로 commit 작성 -> 저장하고 나가면 commit 이 한 개 local repo에 쌓여 있는 상태이다.



## git Commit message 입력

- 모든 사용자가 읽을 수 있도록 되도록이면 영어를 사용해 작성
- `feat:, docs:, test:, refactor:` 정도의 말머리만 잘 붙여도 깔끔한 관리가 가능.
  - Reference: [Conventional commits](https://www.conventionalcommits.org/en/v1.0.0-beta.2/)
- 내용은 optional body에 Enter로 구분하여 작성하며, 문장형으로 작성합니다.

```
<말머리>[optional scope]: <제목>

[optional body]

[optional footer]
```

1. commit 이 끝났다면 remote repository로 push.
   - 첫 commit이라면, -u(–set-upstream) flag를 붙여 push. -> 현재 작업중인 branch가 업로드할 branch의 변동사항을 추적하도록 설정
     `$ git push -u origin master`
   - 이후에는 -u 옵션 없이 바로 push 가능
     `$ git push origin master`



```` shell
$ git remote add origin https:/repo 주소
$ git remote # origin
$ git remote get-url origin https:/repo 주소
$ git remote -v
````

> `$ git status ` 를 이용하여 commit 을 확인 후 push를 진행한다.
>
> - `$ git push -u origin master` 명령어 사용 
>
> git은 동작하는 최소 단위로 commit이 되어야 함!!!



```markdown
-------- file modified --------

# First repo

This is my first repo.

And i think git is very cool.

## Index

- Bulgogi
- Pizza
- Hamburger

## My favorite language

1. golang
2. julia
3. python
4. HTML

`to emphasize` use bacquote. # 명령문

​``` python # 코드 하이라이트
​``` # 코드 블럭
def get_lotto();
	picked = random.ranint(1, 45)
	print(picked)
​```

```

> 두 줄 띄지 않으면 한 문단으로 이어지기 때문에 문장을 나누고 싶다면 두 줄을 띄어야 한다. 



````markdown
docs: Practice Marksown syntax

I learned aboy markdown syntax.
Md is much better than HTML.

# :wq
````





- 커밋 제목은 50자 이내로 요약하여 작성한다

- 제목과 내용사이 한 칸는 규칙
- prefix를 사용하여 한 눈에 커밋의 용도를 알기 쉽게 한다. 아래는 prefix의 종류.

```shell
feat: features # 새로운 기능 추가
docs: documentations # 문서
conf: configurations 
fix: bug-fix # 버그 수정
test : test # 테스트 코드, 리팩토링 테스트 코드 추가
refactor: refactoring #코드 리팩토링 
ci: Continuous Integration
build: Build
perf: Performance
```

- example

```shell
feat: Create server.java to start flask project
docs: Create README.md
conf: poetry init
test: User model CRUD test complete
```



## Use Hexo

[![asciicast height:400px](https://camo.githubusercontent.com/d2eb483b52f6b581a863adae66311ddbd0e52440/68747470733a2f2f61736369696e656d612e6f72672f612f3233333632362e737667)](https://asciinema.org/a/233626)

````shell
$ hexo new post "title text"
# INFO  Created: ~/Documents/local 주소 ... ...  / xxxx.md
$ vi  ~/Documents/ INFO 주소 / xxxx.md
$ hexo clean && hexo generate
$ hexo server # 페이지 확인하는 과정
$ hexo deploy

````



-------------------

## Practice!!!!!

1. `TIL` repo를 생성한 뒤 `clone` 명령어를 사용해 작업공간으로 복사하여 오늘 배운 것을 git/만든날짜-git-start.md 에 정리하여 업로드 하기

```
/TIL
  /git
    /만든날짜-git-start.md
  README.md
  LICENSE
  .gitignore
```

2. Hexo에 포스트 3개 이상 업로드 하기 

