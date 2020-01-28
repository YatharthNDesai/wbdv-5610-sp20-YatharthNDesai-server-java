
let $usernameFLD
let $passwordFLD
let $createBtn
let $updateBtn
let $firstNameFLD
let $lastNameFLD
let $roleFLD
let $templateRow
let $tableBody
let userList = []
let $deleteBtn
let $editBtn
let userService

// let userList = []
// userList.push(user1)
// userList.push(user2)
// console.log(userList)
main = () => {
    let user = new AdminUserServiceClient()
    userService = user
    userService
        .findAllUsers()
        .then(theusers => {
            userList = theusers
            renderUsers()
        })

    // bind DOM elements to local variables
    $createBtn = $("#wbdv-create-btn");
    $deleteBtn = $("#wbdv-remove")
    $usernameFLD = $("#usernameFld");
    $passwordFLD = $("#passwordFld")
    $firstNameFLD = $("#firstNameFld");
    $lastNameFLD = $("#lastNameFld");
    $updateBtn = $("#wbdv-update-btn");
    $roleFLD = $("#roleFld");
    $templateRow = $("#template-row");
    $tableBody = $("#wbdv-table");
    $createBtn.click(createUser);

    // bind buttons to event handlers
    // $createBtn.click(createUser);
    // $updateBtn.click(updateUser())

}

let $table = jQuery("#wbdv-table")

function findAllUsers() {
    console.log(userList[currentUser] + "FindAll")
    userService
        .findAllUsers()
        .then(theusers => {
            userList = theusers
            renderUsers()
        })
}

function renderUsers() {
    console.log(userList[currentUser] + "Render")
    $table.empty()
    for (let u in userList) {
        let user = userList[u]

        $deleteBtn = $("<td><button><i  class=\"fa fa-times wbdv-remove\"></i></button></td>")
        $deleteBtn.click(() => deleteUser(u))

        $editBtn = $("<td><button><i class=\"fa fa-pen wbdv-edit\"></i></button></td>")
        $editBtn.click(() => editUser(u))

        let $data = $(
            `<td>${user.username}</td><td>${user.password}</td><td>${user.firstName}</td>" +"<td>${user.lastName}</td><td>${user.role}</td>`)
        let $row = $("<tr>")
        $row.append($data)
        let $btn = $("<td>")
        $btn.append($deleteBtn)
        $btn.append($editBtn)
        $row.append($btn)
        $table.append($row)
        // $updateBtn.click(updateUser());
    }
}

const createUser = () => {
    console.log(userList[currentUser] + "Create")
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
                                          findAllUsers()

                                      }
    )
}
let currentUser = 1

const editUser = (index) => {
    let user = userList[index]
    console.log(userList[currentUser] + "Create")
    let userId = user._id
    currentUser = index

    userService.findUserById(userId)
        .then(actualUser => {
            $usernameFLD.val(actualUser.username)
            $passwordFLD.val(actualUser.password)
            $firstNameFLD.val(actualUser.firstName)
            $lastNameFLD.val(actualUser.lastName)
            $roleFLD.val(actualUser.role)
        })
}

const updateUser = () => {

    const updatedUser = {
        username: $usernameFLD.val(),
        password: $passwordFLD.val(),
        firstName: $firstNameFLD.val(),
        lastName: $lastNameFLD.val(),
        role: $roleFLD.val()
    }
    $usernameFLD.val("")

    $passwordFLD.val("")

    $firstNameFLD.val("")

    $lastNameFLD.val("")

    $roleFLD.val("")
    console.log(userList[currentUser] + "Update")
    // updatedUser._id = userList[currentUser]._id
    console.log(updatedUser._id)
    // updatedUser._id = user._id

    // userService.updateUser(updatedUser._id, updatedUser)
    //     .then((actualUser) => {
    //         findAllUsers()
    //     })
}

const deleteUser = (index) => {
    console.log(userList[currentUser] + "Delete")
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
