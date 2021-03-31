# FinalProject
<h1> 1.Action

<h2> (1).HomePage Action

---

<h3> a.Request Main Page (Login or not Login, its different results)

<h4> MainAction

<h4> &nbsp;&nbsp; return List(Object)

---

<h3> b.Login Page

<h4> LoginAction(String Username, String Password, String type) (0 for normal user, 1 for publisher user)

<h4> &nbsp;&nbsp; return 0 or 1; 0 = false, 1 = true;

---

<h3> c.Publish Recruitment Information

<h4> PublishAction(String Title, String Information, String CompanyId)

<h4> &nbsp;&nbsp; return 0 or 1; 0 = false, 1 = true;

---

<h3> d.Change Publish Information

<h4> ChangePublishInfo(String PublishId, String Title, String Information, String CompanyId);

<h4> &nbsp;&nbsp; return 0 or 1; 0 = false, 1 = true;

---

<h3> e.Cancel Recruitment Information

<h4> CancelAcction(String RecruitmentId)

<h4> &nbsp;&nbsp; return 0 or 1; 0 = false, 1 = true;

---

<h2> (2).User Information Page

---

<h3> a.Current Login User Information

<h4> UserInfoAction(String UserId)

<h4> &nbsp;&nbsp;return User;

---

<h3> b.Change User Information

<h4> ChangeUserInfo(String UserId, String UserName, String Password, ... (in User Object Fields));

<h4> &nbsp;&nbsp; return 0 or 1; 0 = false, 1 = true;

---

<h3> c.Liked Recuritment Information

<h4> CheckUserCollection(String userId);

<h4> &nbsp;&nbsp; return List(PublichInformation);

---

<h3> d.Cancel Liked Recuritment Information

<h4> CancelUserCollection(String userId, String publishInforId);

<h4> &nbsp;&nbsp; return 0 or 1; 0 = false, 1 = true;

---

<h2> (3).Publisher Information Page

---

<h3> a.CurrentPublisherInformation

<h4> CurrentPublisherInfo(String userId);

<h4> &nbsp;&nbsp; return User;

---

<h3> b.Check All Recuritment Information

<h4> CheckApplications(String userId);

<h4> &nbsp;&nbsp; return List(PublishInformation)

---

<h3> c.Cancel Recuritment

<h4> CancelApplication(String PublishInformationId);

<h4> &nbsp;&nbsp; return 0 or 1; 0 = false, 1 = true;

---

<h3> d.Modify Publisher Information

<h4> ChangePublisherInfo(String userId, ... (fields in Publisher Object));

---

<h3> e.Change Recuritment Information

<h4> ChangerePublishInfo(String publishInfoId, ....(fields in PublishInformation Object));

---

<h1> 2.Object Information

---

<h2> (1).User Object


```
public class User

private String Id;

private String username;

private String password;

private int gender;

private string phone;

private string profile;

private int type;//do not show to user this field

```

<h2> (2).Publisher Object

---

```
public class Publisher

private String id;

private String username;

private String password;

private string phone

private int type; // do not show to user this field
```

<h2> (3).Publish Information

---

```
public class PublishInformation

private string publishInfoId;

private string publisherId;

private string title;

private string profile;
```

<h1> 3.Database Information

<h2> (1). User (user and publisher use same table) 

| userId | username | password | gender | phone | profile | type |
| :------: | :------: | :------: | :------: | :------: | :------: | :------: |
| string | string | string | int | string | string | int |

---

<h2> (2). PublishInfo

| publishId | title | profile |
| :------: | :------: | :------: |
| string | string | string |

---

<h2> (3). PublisherAndPublishInfo

| userId | publishId |
| :---: | :---: |
| string | string |

---

<h3> (4). UserLikedPublishInfo

| userId | publishId |
| :---: | :---: |
| string | string |

## End
