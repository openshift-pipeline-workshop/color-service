function callColorBackend() {
  $.ajax({
    url: 'http://localhost:8080/color',
    success: function (data) {
      console.log(data);
    },
  });
  setTimeout(executeQuery, 1000);
}

$(document).ready(function () {
  setTimeout(callColorBackend, 1000);
});
