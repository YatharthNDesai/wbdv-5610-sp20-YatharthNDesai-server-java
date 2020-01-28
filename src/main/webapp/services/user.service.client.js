function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/001377543/users';
    var self = this;
    function createUser(user) {
        return fetch(self.url,{
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                "content-type": "application/json"
            }
        }).then(response => response.json())

    }
    function findAllUsers() {
       return fetch(self.url).then((response) =>
            // console.log(response)
             response.json()
        )
       //  let promise = fetch(self.url)
       //  promise.then(function (response) {
       //      console.log(response)
       //
       //  })
    }
    function findUserById(userId) {
        return fetch(`${self.url}/${userId}`)
            .then((response => response.json()))
    }
    function updateUser(userId, user) {
        return fetch(`${self.url}/${userId}`,{
            method: 'PUT',
            body: JSON.stringify(user),
            headers: {
                "content-type": "application/json"
            }
        }).then(response => response.json())

    }
    function deleteUser(userId) {
        return fetch(`${self.url}/${userId}`,{
            method: 'DELETE'
        })
    }
}
