function addNote(button) {
    var text = $(button).siblings('textarea').val();
    $.ajax({
      type: 'POST',
      url: 'notes/add',
      data: {'text': text},
      success: function(data) {
        $('#list_notes_table').prepend('<tr data-note-id="' + data.noteId + '"><td>'
                                    + data.text + '</td><td><button onclick="removeNote(this);">Remove</button></td></tr>');
        $(button).siblings('textarea').val('');
      }
    });
}

function removeNote(button) {
    var tr = $(button).parent().parent(),
        noteId = tr.data('note-id');
    $.ajax({
      type: 'POST',
      url: 'notes/remove',
      data: {'noteId': noteId},
      success: function(data) {
        if(data) {
            tr.remove();
        }
      }
    });
}