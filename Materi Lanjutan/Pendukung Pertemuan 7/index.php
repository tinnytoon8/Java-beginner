<?php

header("Content-Type: application/json");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

$dataFile = 'data.json';

// Fungsi untuk membaca data dari file
function readData() {
    global $dataFile;
    if (!file_exists($dataFile)) {
        file_put_contents($dataFile, json_encode([]));
    }
    $content = file_get_contents($dataFile);
    if ($content === false) {
        return [];
    }
    return json_decode($content, true);
}

// Fungsi untuk menulis data ke file
function writeData($data) {
    global $dataFile;
    file_put_contents($dataFile, json_encode($data, JSON_PRETTY_PRINT));
}

// Ambil metode HTTP
$method = $_SERVER['REQUEST_METHOD'];

if ($method === 'GET') {
    // Tampilkan semua data
    $data = readData();
    echo json_encode($data);

} elseif ($method === 'POST') {
    // Ambil input mentah
    $input = file_get_contents("php://input");

    // Pecah berdasarkan koma
    $dataArray = explode(",", $input);

    if (count($dataArray) === 3) {
        // Ambil dan bersihkan input
        $nama = trim($dataArray[0]);
        $npm = preg_replace('/\s+/', '', $dataArray[1]);
        $kelas = preg_replace('/\s+/', '', $dataArray[2]);

        // Optional: validasi NPM & kelas
        if (!is_numeric($npm)) {
            http_response_code(400);
            echo json_encode(["error" => "NPM harus berupa angka."]);
            exit;
        }

        if (strlen($kelas) < 3 || strlen($kelas) > 10) {
            http_response_code(400);
            echo json_encode(["error" => "Format kelas tidak valid."]);
            exit;
        }

        // Buat data baru
        $data = readData();
        $newUser = [
            "id" => count($data) + 1,
            "nama" => $nama,
            "npm" => $npm,
            "kelas" => $kelas
        ];

        // Simpan data
        $data[] = $newUser;
        writeData($data);

        // Kirim response
        echo json_encode([
            "message" => "Data berhasil ditambahkan",
            "user" => $newUser
        ]);
    } else {
        http_response_code(400);
        echo json_encode(["error" => "Format input tidak valid. Gunakan format: nama,npm,kelas"]);
    }

} else {
    http_response_code(405);
    echo json_encode(["message" => "Metode tidak diizinkan"]);
}

?>
