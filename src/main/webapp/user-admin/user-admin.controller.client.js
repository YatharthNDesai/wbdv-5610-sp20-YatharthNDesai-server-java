let $usernameFLD
let $passwordFLD
let $createBtn
let $updateBtn
let $firstNameFLD
let $lastNameFLD
let $roleFLD
let $templateRow
let $tableBody
let userService
let userList = []
let $deleteBtn
let $editBtn

// let userList = []
// userList.push(user1)
// userList.push(user2)
// console.log(userList)
main = () => {
    // bind DOM elements to local variables
    $createBtn = $("#wbdv-search-btn");
    $deleteBtn = $("#wbdv-remove")
    $usernameFLD = $("#usernameFld");
    $passwordFLD = $("#passwordFld")
    $firstNameFLD = $("#firstNameFld");
    $lastNameFLD = $("#lastNameFld");
    $updateBtn = $("#wbdv-edit");
    $roleFLD = $("#roleFld");
    $templateRow = $("#template-row");
    $tableBody = $("#wbdv-table");
    $updateBtn.click(updateUser())
    let user = new AdminUserServiceClient()
    userService = user
    userService.findAllUsers().then(remoteUsers => {
        userList = remoteUsers

        // for (let u in userList) {
        //     const templateRowClone = $templateRow.clone();
        // templateRowClone.css("display", "table-row");
        // templateRowClone.removeAttr("id");
        //
        // templateRowClone.find(".wbdv-username").html("He");
        // templateRowClone.find(".wbdv-first-name").html("is");
        // templateRowClone.find(".wbdv-last-name").html("baf");
        // templateRowClone.find(".wbdv-role").html("sc");
        // templateRowClone.find(".wbdv-remove-btn").click(deleteUser);
        renderUsers()
        //
        // }

    })
    // bind buttons to event handlers
    $createBtn.click(createUser);
    // $deleteBtn.click(deleteUser(u));
    // for (let u in userList) {
    //     $editBtn.click(editUser(u))
    // }
    // let user = new AdminUserServiceClient()
    // userService = user
    // userService.findAllUsers().then(remoteUsers => {
    //     userList = remoteUsers
    //     renderUsers()
    // })
}

let $table = jQuery("#wbdv-table")
// $table.append("<tr><td>Hello</td><td>&nbsp;</td><td>Yatharth</td><td>Desai</td><td>Student</td></tr>")
// function renderUsers() { $table.empty() for (let u in userList) {  let $userLi =
// (`<tr><td>${userList[u].username}</td><td>&nbsp;</td><td>${userList[u].firstName}</td><td>${userList[u].lastName}</td><td>${userList[u].role}</td>
// <td>$deleteBtn</td>$editBtn</tr>`) // $deleteBtn.click(() => { //     userList.splice(u,1) // })
// $table.append($userLi)  }  } const renderUser = () => { $table.empty()  for (let u in userList)
// {  const user = userList[u]; const rowClone = $templateRow.clone(); rowClone.css("display",
// "table-row"); rowClone.removeAttr("id"); rowClone.find(".wbdv-username").html(user.username);
// rowClone.find(".wbdv-first-name").html(user.firstName);
// rowClone.find(".wbdv-last-name").html(user.lastName);
// rowClone.find(".wbdv-role").html(user.role); let className = "wbdv-remove"+u;
// rowClone.find(".wbdv-remove").attr("id",className) console.log($('.wbdv-remove').attr("id")) let classPass = '#' + className $table.append(rowClone); const $deleteBtn = $('#wbdv-remove1'); console.log(className) $deleteBtn.click(() => { deleteUser(u) }); templateRowClone.css("display", "table-row"); templateRowClone.removeAttr("id"); }

// const newtemplateRowClone = $templateRow.clone();
// newtemplateRowClone.css("display", "table-row");
// newtemplateRowClone.removeAttr("id");
//
// newtemplateRowClone.find(".wbdv-username").html(templateRowClone.username);
// newtemplateRowClone.find(".wbdv-first-name").html(templateRowClone.firstName);
// newtemplateRowClone.find(".wbdv-last-name").html(templateRowClone.lastName);
// newtemplateRowClone.find(".wbdv-role").html(templateRowClone.role);
// newtemplateRowClone.find(".wbdv-remove-btn").click(deleteUser);
// // newtemplateRowClone.find("wbdv-edit-btn").click(editUser())
// $table.append(newtemplateRowClone)
// }
function findAllUsers() {
    userService
        .findAllUsers()
        .then(theusers => {
            userList = theusers
            renderUsers()
        })
}
function renderUsers() {
    $table.empty()
    for (let u in userList) {
        let user = userList[u]

        $deleteBtn = $("<td><button><i  class=\"fa fa-times wbdv-remove\"></i></button></td>")
        $deleteBtn.click(() => deleteUser(u))

        $editBtn = $("<td><button><i class=\"fa fa-pen wbdv-edit\"></i></button></td>")
        $editBtn.click(() => editUser(u))

        let $data = $(
            `<td>${user.username}</td><td>${user.password}</td><td>${user.firstName}</td>" +"<td>${user.lastName}</td><td>${user.role}</td>`)
        // $data.append($deleteBtn)
        // $data.append($editBtn)
        let $row = $("<tr>")
        $row.append($data)
        let $btn = $("<td>")
        $btn.append($deleteBtn)
        $btn.append($editBtn)
        $row.append($btn)// $li = $("<li>") //
        // $li.append($deleteBtn) // $li.append($editBtn) // $li.append(user.username) //
        // $li.append(user.username)
        $table.append($row)
    }
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

                                          // const templateRowClone = $templateRow.clone();
                                          // templateRowClone.css("display", "table-row");
                                          // templateRowClone.removeAttr("id");
                                          //
                                          // templateRowClone.find(".wbdv-username").html(username);
                                          // templateRowClone.find(".wbdv-first-name").html(firstName);
                                          // templateRowClone.find(".wbdv-last-name").html(lastName);
                                          // templateRowClone.find(".wbdv-role").html(role); //
                                          // templateRowClone.find(".wbdv-remove").click(deleteUser);
                                          // //
                                          // templateRowClone.find(".wbdv-edit").click(editUser);
                                          // userList.push(templateRowClone)
                                          // $table.append(templateRowClone) // renderUser()  //
                                          // userList.push(templateRowClone) //
                                          // $table.append(templateRowClone)

                                          // $deleteBtn = $("<td><button><i  class=\"fa fa-times wbdv-remove\"></i></button></td>")
                                          // $deleteBtn.click(() => deleteUser(u))
                                          //
                                          // $editBtn = $("<td><button><i class=\"fa fa-pen wbdv-edit\"></i></button></td>")
                                          // $editBtn.click(() => editUser(u))
                                          //
                                          // let $data = $(
                                          //     `<td>${user.username}</td><td>${user.password}</td><td>${user.firstName}</td>" +"<td>${user.lastName}</td><td>${user.role}</td>`)
                                          //
                                          // let $row = $("<tr>")
                                          // $row.append($data)
                                          // $row.append($deleteBtn)
                                          // $row.append($editBtn)
                                          // $table.append($row)
        findAllUsers()

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
let currentUserIndex = -1

//
// function editUser(index) {
//     currentUserIndex = index
//     let user = userList[index]
//     let userId = user._id
//
//     userService.findUserById(userId)
//         .then(actualUser => {
//             $usernameFLD.val(actualUser.username)
//         })
// }

// function updateUser() {
//     const username = $usernameFLD.val()
//     $usernameFLD.val("")
//     const password = $passwordFLD.val()
//     $passwordFLD.val("")
//     const firstName = $firstNameFLD.val()
//     $firstNameFLD.val("")
//     const lastName = $lastNameFLD.val()
//     $lastNameFLD.val("")
//     const role = $roleFLD.val()
//     $roleFLD.val("")
//     const updatedUser = {
//         username: username,
//         password: password,
//         firstName: firstName,
//         lastName: lastName,
//         role: role
//     }
//     updatedUser._id = userList[currentUserIndex]._id
//
//     userService.updateUser(updatedUser._id, updatedUser)
//         .then((actualUser) => {
//             findAllUsers()
//         })
// }
// editUser = (event) => {
//     const user = $(event.currentTarget)
//     const _id = user._id
//     userService.findUserById(_id)
//
//         .then(user => {
//             $usernameFLD.val(user.username)
//
//         })
// }

// editUser =  (event) => {
//     const user = $(event.currentTarget)
//     const _id = user._id
//     userService.findUserById(_id)
//         .then(user => {
//             $usernameFLD.val(user.username)
//         })
//
// }

deleteUser = (index) => {
    // console.log(index);

    let user = userList[index]
    const _id = user._id
    console.log(_id)
    userService.deleteUser(_id)
        .then(response => {
            userList.splice(index, 1)
            renderUsers();
        })
};

$(main);
// let $createUserBtn = $("#wbdv-search-btn")
// $createUserBtn.click(createUser)