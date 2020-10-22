function callColorBackend() {
  $.ajax({
    url: '/color',
    success: function (data) {
      console.log('Color: ' + data.hexValue);
      $('.changecolor').css('color', data.hexValue);
      $('.gradient').css(
        'background',
        'linear-gradient(90deg, #000000 0%, ' + data.hexValue + ' 100%)'
      );
    }
  });
  setTimeout(callColorBackend, 1000);
}

function callVersionBackend() {
  $.ajax({
    url: '/version',
    success: function (data) {
      console.log('Version: ' + data.versionString);
      $('#version').text('Version: ' + data.versionString);
    }
  });
  setTimeout(callVersionBackend, 1000);
}

$(document).ready(function () {
  callVersionBackend();
  callColorBackend();
});
