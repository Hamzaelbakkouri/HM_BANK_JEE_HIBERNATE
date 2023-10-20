
const interest_rate = 0.12;

const amount_input = document.getElementById("amount_input");
const amount_ranger = document.getElementById("amount_ranger");

const duration_input = document.getElementById("duration_input");
const duration_ranger = document.getElementById("duration_ranger");

const mnthlypymnt_input = document.getElementById("mnthlypymnt_input");
const mnthlypymnt_ranger = document.getElementById("mnthlypymnt_ranger");


//----------------initialisation-----------------------------------------

mnthlypymnt_config();
display_mnthlypymnt();

//-----------------------------------------------------------------------


//rangers  --> inputs

mnthlypymnt_ranger.addEventListener('change', function () {
    mnthlypymnt_input.value = mnthlypymnt_ranger.value;
    display_duration();
})


//inputs --> rangers

mnthlypymnt_input.addEventListener('change', function () {
    mnthlypymnt_ranger.value = mnthlypymnt_input.value;
    display_duration();
})

//----------------monthly payment ranger configuration

function mnthlypymnt_config() {

    let max = calc_max_mnthlypymnt();
    let min = calc_min_mnthlypymnt();

    mnthlypymnt_ranger.min = min;
    mnthlypymnt_ranger.max = max;

    mnthlypymnt_input.min = min;
    mnthlypymnt_input.max = max;

}

function calc_min_mnthlypymnt() {
    return calc_mnthlypymnt(amount_input.value, 120);
}

function calc_max_mnthlypymnt() {
    return calc_mnthlypymnt(amount_input.value, 12);
}

//-------------------------------------------------------------

//calculate the amount to be paid each month

amount_ranger.addEventListener('change', function () {
    amount_input.value = amount_ranger.value;
    mnthlypymnt_config();
    display_mnthlypymnt();
})

duration_ranger.addEventListener('change', function () {
    duration_input.value = duration_ranger.value;
    display_mnthlypymnt();
})

amount_input.addEventListener('change', function () {
    amount_ranger.value = amount_input.value;
    mnthlypymnt_config();
    display_mnthlypymnt();
})

duration_input.addEventListener('change', function () {
    duration_ranger.value = duration_input.value;
    display_mnthlypymnt();
})

function display_mnthlypymnt() {
    mnthlypymnt_input.value = calc_mnthlypymnt(amount_input.value, duration_input.value);
    mnthlypymnt_ranger.value = mnthlypymnt_input.value;
}

function calc_mnthlypymnt(amount, duration) {
    return ((amount * (interest_rate / 12)) / (1 - Math.pow(1 + (interest_rate / 12), -duration))).toFixed(2);
}

//-----------------------------------------------------------


function display_duration() {

    let duration = calc_duration(amount_input.value, mnthlypymnt_input.value);

    let valid_duration = get_valid_duration(duration);

    duration_input.value = valid_duration;
    duration_ranger.value = valid_duration;

    display_mnthlypymnt();

}

function calc_duration(amount, mnthlypymnt) {
    return -(Math.log(-(((amount * (interest_rate / 12)) / mnthlypymnt) - 1)) / Math.log(1 + (interest_rate / 12)));
}

//----------------------------------------------------------

function get_valid_duration(duration) {
    let valid_duration_min = 12;
    let valid_duration_max = 120;
    let valid_duration = 12;

    if (duration < 12) {
        return valid_duration_min;
    }

    if (duration > 120) {
        return valid_duration_max;
    }

    while (duration > valid_duration) {
        valid_duration += 6;
    }

    if (valid_duration - duration < duration - valid_duration + 6) {
        return valid_duration;
    } else {
        return valid_duration - 6;
    }

}

//--------------------------------------Modal-------------------------------------
// Function to open the modal
function openModal() {
    document.getElementById("myModal").style.display = "block";
}

// Function to close the modal
function closeModal() {
    document.getElementById("myModal").style.display = "none";
}

// Close the modal if the user clicks outside of it
window.onclick = function (event) {
    var modal = document.getElementById("myModal");
    if (event.target == modal) {
        modal.style.display = "none";
    }
}