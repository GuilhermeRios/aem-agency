$(document).ready(function() {

    $(document).on("foundation-contentloaded", function (e) {
        showHideSliderCtaButtonFields($(".cmp-slidercta__editor-show-button", e.target));
    });

    $(document).on("change", ".cmp-slidercta__editor-show-button", function (e) {
        showHideSliderCtaButtonFields($(this));
    });

    function showHideSliderCtaButtonFields(checkbox){
        let dialog = checkbox.parent();
        let container = dialog.find('.cmp-slidercta__editor-container-button');

        if(checkbox.prop('checked')){
            container.show();
        }else{
            container.hide();
        }
    }
});
