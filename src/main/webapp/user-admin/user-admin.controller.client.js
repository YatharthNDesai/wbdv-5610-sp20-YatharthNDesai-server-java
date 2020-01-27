let $usernameFLD
let $passwordFLD
let $createBtn
let $editBtn
let $firstNameFLD
let $lastNameFLD
let $roleFLD
let $templateRow
let $tableBody
let userService
let userList = []

// let userList = []
// userList.push(user1)
// userList.push(user2)
// console.log(userList)
main = () => {
    // bind DOM elements to local variables
    $createBtn = $("#wbdv-search-btn");
    $usernameFLD = $("#usernameFld");
    $passwordFLD = $("#passwordFld")
    $firstNameFLD = $("#firstNameFld");
    $lastNameFLD = $("#lastNameFld");
    $roleFLD = $("#roleFld");
    $templateRow = $("#template-row");
    $tableBody = $("#wbdv-table");
    let user = new AdminUserServiceClient()
    userService = user
    userService.findAllUsers().then(remoteUsers => {
        userList = remoteUsers
        for (let u in userList) {
            // const templateRowClone = $templateRow.clone();
            // templateRowClone.css("display", "table-row");
            // templateRowClone.removeAttr("id");
            //
            // templateRowClone.find(".wbdv-username").html("He");
            // templateRowClone.find(".wbdv-first-name").html("is");
            // templateRowClone.find(".wbdv-last-name").html("baf");
            // templateRowClone.find(".wbdv-role").html("sc");
            // templateRowClone.find(".wbdv-remove-btn").click(deleteUser);
            renderUsers(userList[u])
        }

    })
    // bind buttons to event handlers
    $createBtn.click(createUser);
    for (let u in userList) {
        $editBtn.click(editUser(u))
    }
    // let user = new AdminUserServiceClient()
    // userService = user
    // userService.findAllUsers().then(remoteUsers => {
    //     userList = remoteUsers
    //     renderUsers()
    // })
}

let $table = jQuery("#wbdv-table")
// $table.append("<tr><td>Hello</td><td>&nbsp;</td><td>Yatharth</td><td>Desai</td><td>Student</td></tr>")
//  function renderUsers() { $table.empty() for (let u in userList) {  let $userLi =
// (`<tr><td>${userList[u].username}</td><td>&nbsp;</td><td>${userList[u].firstName}</td><td>${userList[u].lastName}</td><td>${userList[u].role}</td>
// <td>$deleteBtn</td>$editBtn</tr>`) // $deleteBtn.click(() => { //     userList.splice(u,1) // })
//  $table.append($userLi)  }  }
const renderUsers = (templateRowClone) => {
    const newtemplateRowClone = $templateRow.clone();
    newtemplateRowClone.css("display", "table-row");
    newtemplateRowClone.removeAttr("id");

    newtemplateRowClone.find(".wbdv-username").html(templateRowClone.username);
    newtemplateRowClone.find(".wbdv-first-name").html(templateRowClone.firstName);
    newtemplateRowClone.find(".wbdv-last-name").html(templateRowClone.lastName);
    newtemplateRowClone.find(".wbdv-role").html(templateRowClone.role);
    newtemplateRowClone.find(".wbdv-remove-btn").click(deleteUser);
    $table.append(newtemplateRowClone)
}

const createUser = () => {
    const username = $usernameFLD.val()
    $usernameFLD.val("")
    const password = $passwordFLD.val()
    $passwordFLD.val("")
    const firstName = $firstNameFLD.val()
    $firstNameFLD.val("")
    const lastName = $lastNameFLD.val()
    $lastNameFLD.val("")
    const role = $roleFLD.val()
    $roleFLD.val("")
    const user = {
        username: username,
        password: password,
        firstName: firstName,
        lastName: lastName,
        role: role
    }

    userService.createUser(user).then(brandNewUser => {

                                          const templateRowClone = $templateRow.clone();
                                          templateRowClone.css("display", "table-row");
                                          templateRowClone.removeAttr("id");

                                          templateRowClone.find(".wbdv-username").html(username);
                                          templateRowClone.find(".wbdv-first-name").html(firstName);
                                          templateRowClone.find(".wbdv-last-name").html(lastName);
                                          templateRowClone.find(".wbdv-role").html(role);
                                          templateRowClone.find(".wbdv-remove-btn").click(deleteUser);
                                          userList.push(templateRowClone)
                                          $table.append(templateRowClone)
                                          // userList.push(templateRowClone)
                                          // $table.append(templateRowClone)

                                      }
    )
    // const templateRowClone = $templateRow.clone();
    // templateRowClone.css("display","table-row");
    // templateRowClone.removeAttr("id");
    //
    // templateRowClone.find(".wbdv-username").html(username);
    // templateRowClone.find(".wbdv-first-name").html(firstName);
    // templateRowClone.find(".wbdv-last-name").html(lastName);
    // templateRowClone.find(".wbdv-role").html(role);
    // templateRowClone.find(".wbdv-remove-btn").click(deleteUser);
    // $table.append(templateRowClone)

}

const editUser = index => {
    const user = userList[index];
    const _id = user._id
    userService.findUserById(_id)
        .then(user => {
            $usernameFLD.val(user.username)
        })

}

deleteUser = (event) => {
    const $deleteBtn = $(event.currentTarget)
    const $row = $deleteBtn.parent().parent().parent();
    $row.remove();
}

$(main);
// let $createUserBtn = $("#wbdv-search-btn")
// $createUserBtn.click(createUser)