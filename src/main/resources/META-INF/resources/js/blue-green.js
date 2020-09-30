function callColorBackend() {
  $.ajax({
    url: '/color',
    success: function (data) {
      console.log(data.hexValue);
      $('.changecolor').css('color', data.hexValue);
    },
  });
  setTimeout(callColorBackend, 1000);
}

$(document).ready(function () {
  callColorBackend();
});
