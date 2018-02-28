$.noConflict();
(function($) {
  $('#button').on('click', function(e) {
   // e.preventDefault(); //No id value in url
   var valid = {
     name: false,
     ssn: false,
     address: false
   };
    var name = document.getElementById('name').value;
    console.log(name);

    if (name.length < 4 || name.length > 50) {
      if ($('span.namewarning').length <= 0) {
      $('#form-item-name').prepend('<span id="namewarning" class="namewarning">Name shoud be between 4 and 50 characters long.</span>');
      $('#name').css('background', '#D24D57')
    }
    } else {
      $('#namewarning').remove();
      $('#name').css('background', 'white')
      valid.name = true;
    }
    var address = document.getElementById('address').value;
    console.log(address);

    if (address.length < 4 || address.length > 50) {
      if ($('span.addwarning').length <= 0) {
      $('#form-item-address').prepend('<span id="addwarning" class="addwarning">Address shoud be between 4 and 50 characters long.</span>');
      $('#address').css('background', '#D24D57')
      }
    } else {
      $('#addwarning').remove();
      $('#address').css('background', 'white')
      valid.address = true;
    }

    var ssn = document.getElementById('ssn').value;
    console.log(ssn);
    var pattern = /^\d{3}-\d{2}-\d{4}$/;

    if ((pattern.test(ssn)) === true) {
      valid.ssn = true;
      $('#ssnwarning').remove();
      $('#ssn').css('background', 'white')
    } else {
      if ($('span.ssnwarning').length <= 0) {
      $('#form-item-ssn').prepend('<span id="ssnwarning" class="ssnwarning">Social Security Number shoud be in format XXX-XX-XXXX');
      $('#ssn').css('background', '#D24D57');
    }
    }
    console.log(valid);
      if ((valid.address === true) && (valid.name === true) && (valid.ssn === true)) {
        console.log("here");
        $("#signup-form").attr("action", "validateServlet");
        $("#signup-form").attr("method", "get");
        $('#signup-form').submit();
      }

    $('#signup-form').on('submit', function(e) {
      console.log("submit");
      
  });
});
})(jQuery);
