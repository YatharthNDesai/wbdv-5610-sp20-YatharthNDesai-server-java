let $usernameFLD
let $createBtn
let $firstNameFLD
let $lastNameFLD
let $roleFLD
let $templateRow
let $tableBody


// let userList = []
// userList.push(user1)
// userList.push(user2)
// console.log(userList)
main = () => {
    // bind DOM elements to local variables
    $createBtn = $("#wbdv-search-btn");
    $usernameFLD = $("#usernameFld");
    $firstNameFLD  = $("#firstNameFld");
    $lastNameFLD = $("#lastNameFld");
    $roleFLD = $("#roleFld");
    $templateRow = $("#template-row");
    $tableBody = $("#wbdv-table");

    // bind buttons to event handlers
    $createBtn.click(createUser);
}

let $table = jQuery("#wbdv-table")
// $table.append("<tr><td>Hello</td><td>&nbsp;</td><td>Yatharth</td><td>Desai</td><td>Student</td></tr>")
//
// function renderUsers() {
//     $table.empty()
//     for (let u in userList) {
//
//         let $userLi = (`<tr><td>${userList[u].username}</td><td>&nbsp;</td><td>${userList[u].firstName}</td><td>${userList[u].lastName}</td><td>${userList[u].role}</td>
// <td>$deleteBtn</td>$editBtn</tr>`)
//         // $deleteBtn.click(() => {
//         //     userList.splice(u,1)
//         // })
//
//         $table.append($userLi)
//
//     }
//
// }

const createUser = () => {
    const username = $usernameFLD.val()
    $usernameFLD.val("")
    const firstName = $firstNameFLD.val()
    $firstNameFLD.val("")
    const lastName = $lastNameFLD.val()
    $lastNameFLD.val("")
    const role = $roleFLD.val()
    $roleFLD.val("")
    const templateRowClone = $templateRow.clone();
    templateRowClone.css("display","table-row");
    templateRowClone.removeAttr("id");

    templateRowClone.find(".wbdv-username").html(username);
    templateRowClone.find(".wbdv-first-name").html(firstName);
    templateRowClone.find(".wbdv-last-name").html(lastName);
    templateRowClone.find(".wbdv-role").html(role);
    templateRowClone.find(".wbdv-remove-btn").click(deleteUser);
    $table.append(templateRowClone)


}

deleteUser = (event) => {
    const $deleteBtn = $(event.currentTarget)
    const $row = $deleteBtn.parent().parent().parent();
    $row.remove();
}

$(main);
// let $createUserBtn = $("#wbdv-search-btn")
// $createUserBtn.click(createUser)

